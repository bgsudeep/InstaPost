package com.instapost.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.instapost.domain.Magazine;
import com.instapost.repository.MagazineRepository;
import com.instapost.service.MagazineService;

@Service
@Transactional
public class MagazineServiceImpl implements MagazineService {

	@Autowired
	MagazineRepository magazineRepository;

	@Override
	public void saveMagazine(Magazine magazine) {
		magazineRepository.save(magazine);
	}

	@Override
	public List<Magazine> listMagazine() {
		List<Magazine> magazineList = new ArrayList<Magazine>();

		magazineList = (List<Magazine>) magazineRepository.findAll();

		return magazineList;
	}

	@Override
	public void deleteMagazine(long magzineId) {

		magazineRepository.delete(magzineId);

	}



	@Override
	public Magazine editMagazine(Magazine magazine) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Magazine findoneMagazine(long magzineId) {
		magazineRepository.findOne(magzineId);
		
		
		return magazineRepository.findOne(magzineId);
	}

}
