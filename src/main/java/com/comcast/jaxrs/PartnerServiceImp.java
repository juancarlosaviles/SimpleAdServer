package com.comcast.jaxrs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

public class PartnerServiceImp implements PartnerService {

	private long currentId = 1;
	Map<Long, Partner> partners = new HashMap<Long, Partner>();
	
	public PartnerServiceImp() {
		init();
	}

	final void init() {
		Partner partner = new Partner();
		partner.setPartnerId(currentId);
		partner.setDuration(5);
		partner.setCreatedDate(partner.getCreatedDate());
		partner.setExpirationDate(partner.getCreatedDate().plusSeconds(partner.getDuration()));
		partner.setAdContent("The best Ad Campain Ever!!");
		partners.put(partner.getPartnerId(), partner);
	}
	
	@Override
	public Partner getAdCampain(String id) {
		System.out.println("Calling getAdCampain method");
		Long partnerId = Long.parseLong(id);
		Partner partner = partners.get(partnerId);
		if(partner.getExpirationDate().isAfterNow()){
			return partner;
		}else{
			System.out.println("No active ad campaigns exist for the specified partner");
	        return null;
		}
	}

	@Override
	public Response addAdCampain(Partner partner) {
		System.out.println("Calling addAdCampain");
		System.out.println("Duration:"+partner.getDuration());
		System.out.println("Content:"+partner.getAdContent());
		System.out.println("Created Date:"+partner.getCreatedDate());
		partner.setPartnerId(++currentId);
		System.out.println("ID:"+partner.getPartnerId());
		partner.setExpirationDate(partner.getCreatedDate().plusSeconds(partner.getDuration()));
		System.out.println("Expiration Date:"+partner.getExpirationDate());
		partners.put(partner.getPartnerId(), partner);
		return Response.ok(partner).build();
	}




}
