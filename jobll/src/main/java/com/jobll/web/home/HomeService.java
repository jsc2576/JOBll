package com.jobll.web.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.home.HomeRepository;
import com.jobll.web.home.Home;
import java.util.Random;
@Service
public class HomeService {

    @Autowired
    HomeRepository homeRepository;
    

    public int create(Home entity) throws Exception{
    	Random random = new Random();
    	entity.setTest_idx(random.nextInt(1000)+1);
		return homeRepository.create(entity);

    }

 

}
