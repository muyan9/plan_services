package com.zcy.test;

import java.net.URL;

import org.codehaus.xfire.client.Client;

import com.zcy.common.Base64;

public class test_db_operation {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String target = "http://localhost:8080/axis2/services/db_opration?wsdl";

		Client client = new Client(new URL(target));
		String sql = "insert into geo_record(lat, lng) values(1,1)";
		Object[] results = client
				.invoke("ExecuteSQL",
						new Object[] { Base64.encode(sql) });
		System.out.println(results[0]);
	}
}