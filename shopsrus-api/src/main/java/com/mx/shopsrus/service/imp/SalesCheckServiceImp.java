package com.mx.shopsrus.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.shopsrus.dto.ResponseSalesCheckDto;
import com.mx.shopsrus.entity.Offer;
import com.mx.shopsrus.entity.Product;
import com.mx.shopsrus.entity.SalesCheck;
import com.mx.shopsrus.repository.ClientRepository;
import com.mx.shopsrus.repository.OfferRepository;
import com.mx.shopsrus.repository.ProductRepository;
import com.mx.shopsrus.repository.SalesCheckRepository;
import com.mx.shopsrus.service.SalesCheckService;
import com.mx.shopsrus.tools.Operations;

@Service
public class SalesCheckServiceImp implements SalesCheckService {

	@Autowired
	SalesCheckRepository salesCheckRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OfferRepository offerRepository;

	@Override
	public ResponseSalesCheckDto getById(Long id) {

		ResponseSalesCheckDto response = new ResponseSalesCheckDto();
		Double descuento = 0.0;

		SalesCheck factura = salesCheckRepository.getById(id);
		if (factura == null) {
			return null;
		} else {

			if (factura.getCliente().getId() > 0) {

				factura.setCliente(clientRepository.getById(new Long(factura.getCliente().getId())));
			}

			factura.setProductos(productRepository.getBySalesCheck(id));
			Double importe = factura.getProductos().stream().mapToDouble(Product::getPrecio).sum();

			int antiguedad = Operations.calculaAntiguedad(factura.getCliente().getFecha_antiguedad());

			System.out.println(antiguedad);

			List<Offer> descuentos = offerRepository
					.getByUser(Operations.TryParseLong(factura.getCliente().getTipo_usuario()), importe, antiguedad);

			if (descuentos.size() > 0) {
				descuento = Operations.calculaDescuento(descuentos, factura.getProductos());

			}

			factura.setImporte_total(importe);
			factura.setDescuento(descuento);
			factura.setImporte_con_descuento(importe - descuento);

			response.setSalesCheck(factura);
			response.setCode("200");
			response.setMessage("success");

			return response;
		}
	}

}
