package com.instapost.service;

import java.util.List;

import com.instapost.domain.Magazine;

public interface MagazineService {

	public void saveMagazine(Magazine magazine);

	public Magazine editMagazine(Magazine magazine);
	public List<Magazine> listMagazine();
	public void deleteMagazine(Integer magzineId );

	public Magazine findoneMagazine(Integer magzineId);

	
}
