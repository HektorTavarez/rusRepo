package com.mx.shopsrus.repository.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.shopsrus.dto.ResponseOfferDto;
import com.mx.shopsrus.entity.Offer;
import com.mx.shopsrus.repository.OfferRepository;
import com.mx.shopsrus.repository.sp.OfferSP;
import com.mx.shopsrus.tools.Constants;

@Transactional
@Repository
public class OfferRepositoryImp implements OfferRepository {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Offer> getAll() {
		return new OfferSP(jdbcTemplate, "spRusCDescuentos",Constants.GET_ALL).getAll();
	}

	@Override
	public Offer getById(Long id) {
		List<Offer> response = new OfferSP(jdbcTemplate, "spRusCDescuentosId",Constants.FIND_BY_ID).findById(id);
		
		if(response.size() > 0) {
			return response.get(0);
		}else {
			return null;
		}		
	 
	}
	
	
	@Override
	public ResponseOfferDto save(Offer offer) {
		List<ResponseOfferDto> response = new OfferSP(jdbcTemplate, "spRusIDescuentos",Constants.SAVE).save(offer);
		
		if(response.size() > 0) {
			return response.get(0);
		}else {
			return null;
		}		
	 
	}
	
	
	@Override
	public List<Offer> getByUser(Long id, Double monto,int antiguedad) {
		return new OfferSP(jdbcTemplate, "spRusCOfertasUsuario",Constants.FIND_BY_USER).findByUser(id,monto, antiguedad);
	}

	
	
}
