package com.xingyoucai.irm;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Test;

import com.google.common.io.Files;
import com.xingyoucai.irm.http.OkHttpUtils;

public class AppTest {

	@Test
	public void test() throws IOException {
		
		String host="https://ssl-fof.xingyoucai.com";
		
		String result="";
		//基金信息
		result=OkHttpUtils.post(host+"/api/v1/save/fundInfo",getJson("Fundinfo.json"));
		//净值信息
//		result=OkHttpUtils.post(host+"/api/v1/save/nvDataList",getJson("Nvdata.json"));
//		//Fund持仓--可选
//		result=OkHttpUtils.post(host+"/api/v1/save/fundHoldingList",getJson("Fundholding.json"));
//		//Fof持仓--可选
//		result=OkHttpUtils.post(host+"/api/v1/save/fofHoldingList",getJson("FofHoldingList.json"));
//		//期货持仓--可选
//		result=OkHttpUtils.post(host+"/api/v1/save/futuresHoldDataList",getJson("FuturesHoldData.json"));
//		//结算单--可选
//		result=OkHttpUtils.post(host+"/api/v1/save/futuresTradeDataList",getJson("FuturesTradeData.json"));
//		//开始计算
//		result=OkHttpUtils.get(host+"/api/v1/generator/Test");
//		//计算结果
//		result=OkHttpUtils.get(host+"/api/v1/chart/Test/809,807");//自由组合
		
		System.out.println(result);
 
	}

	private String getJson(String name) throws IOException{
		return Files.toString(new File("src/main/resources/data/"+name), Charset.forName("utf-8"));
	}
}
