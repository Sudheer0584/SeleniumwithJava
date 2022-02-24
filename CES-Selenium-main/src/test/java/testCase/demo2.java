package testCase;


import org.testng.annotations.Test;

import util.Common.BaseUtil;
import util.Common.RestAPIUtil;
public class demo2 extends BaseUtil{


	@Test
    public void getUser(){
		String baseURI ="https://reqres.in/";
		String AuthorName ="Dhakshna";
		String TagName ="getUserTest";

    	RestAPIUtil restAPI= RestAPI(baseURI,AuthorName,TagName);
    	restAPI.Log(restAPI.getStatusCode("api/users/2"));
    	restAPI.Log(restAPI.getBody("api/users/2"));


    }

}

