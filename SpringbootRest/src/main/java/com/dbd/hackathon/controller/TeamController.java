package com.dbd.hackathon.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbd.hackathon.model.Members;

@RestController
//@EnableAutoConfiguration
public class TeamController {

	@RequestMapping(value = "/membersJSONObject", method = RequestMethod.GET)
	public String listMembers1() throws JSONException  {

		/** Using JSONOBject does not produce right results.
		 * Need to identify a work around.
		 */
		JSONObject jsonObject = new JSONObject();
		Members mem1 = new Members("Ambica", 123);
		Members mem2 = new Members("Brunda", 234);
		Members mem3 = new Members("Preyansh", 456);
		Members mem4 = new Members("Siddharth", 567);

		jsonObject.put("member1", mem1);
		jsonObject.put("member2", mem2);
		jsonObject.put("member3", mem3);
		jsonObject.put("member4", mem4);

		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public List<Members> listMembers2() throws JSONException  {

		/** We can send a custom object, but this creates a depepndancy at the client side.
		 * i.e. We will need to specify the type of object we are expecting, at client side
		 */
		Members mem1 = new Members("Ambica", 123);
		Members mem2 = new Members("Brunda", 234);
		Members mem3 = new Members("Preyansh", 456);
		Members mem4 = new Members("Siddharth", 567);

		List<Members> memberList = new ArrayList<>();
		memberList.add(mem1);
		memberList.add(mem2);
		memberList.add(mem3);
		memberList.add(mem4);
		
		return memberList;
	}
	
}
