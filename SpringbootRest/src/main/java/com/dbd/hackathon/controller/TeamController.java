package com.dbd.hackathon.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbd.hackathon.model.Members;
import com.dbd.hackathon.model.Team;

@RestController
public class TeamController {

	Members mem1 = new Members("Ambica", 123);
	Members mem2 = new Members("Brunda", 234);
	Members mem3 = new Members("Preyansh", 456);
	Members mem4 = new Members("Siddharth", 567);
	List<Members> memberList = new ArrayList<>();
	Team team = new Team(null, memberList);
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/membersJSONObject", method = RequestMethod.GET)
	public String listMembers1() {

		/** Using JSONOBject does not produce right results.
		 * Need to identify a work around.
		 */
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("member1", mem1);
		jsonObject.put("member2", mem2);
		jsonObject.put("member3", mem3);
		jsonObject.put("member4", mem4);

		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public List<Members> listMembers2() {

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
	
	@RequestMapping(value = "/membersJSONRE", method = RequestMethod.GET)
	public ResponseEntity<List<Members>> listMembers3()  {

		/** Using JSONOBject does not produce right results.
		 * Need to identify a work around.
		 */
		memberList.add(mem1);
		memberList.add(mem2);
		memberList.add(mem3);
		memberList.add(mem4);
		
		return ResponseEntity.ok(memberList);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/membersSimpleJSON", method = RequestMethod.GET)
	public String listMembers4()  {

		/** Using JSONOBject does not produce right results.
		 * Need to identify a work around.
		 */
		memberList.add(mem1);
		memberList.add(mem2);
		memberList.add(mem3);
		memberList.add(mem4);
		Map<String, Object> map;
		
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		for(Members mem : memberList) {
			
			map = new HashMap<>();
			
			map.put("id", mem.getEmpId());
			map.put("name", mem.getName());
			jsonArray.add(map);	
		}
		jsonObject.put("manager", team.getManagerName());
		jsonObject.put("members", jsonArray);
		
		return jsonObject.toJSONString();
	}
	
	@RequestMapping(value = "/addManager", method = RequestMethod.POST)
	public void addManager(@RequestBody String jsonMessage) throws ParseException {

		/** Using JSONOBject does not produce right results.
		 * Need to identify a work around.
		 */
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonMessage);
		
		String managerName = (String) jsonObject.get("manager");
		team.setManagerName(managerName);
	}
}
