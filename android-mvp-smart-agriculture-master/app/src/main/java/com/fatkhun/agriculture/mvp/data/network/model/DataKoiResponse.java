package com.fatkhun.agriculture.mvp.data.network.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DataKoiResponse{

	@SerializedName("averageSuhu")
	private double averageSuhu;

	@SerializedName("pHdata")
	private List<String> pHdata;

	@SerializedName("averagepH")
	private double averagepH;

	@SerializedName("SuhuData")
	private List<String> suhuData;

	public void setAverageSuhu(double averageSuhu){
		this.averageSuhu = averageSuhu;
	}

	public double getAverageSuhu(){
		return averageSuhu;
	}

	public void setPHdata(List<String> pHdata){
		this.pHdata = pHdata;
	}

	public List<String> getPHdata(){
		return pHdata;
	}

	public void setAveragepH(double averagepH){
		this.averagepH = averagepH;
	}

	public double getAveragepH(){
		return averagepH;
	}

	public void setSuhuData(List<String> suhuData){
		this.suhuData = suhuData;
	}

	public List<String> getSuhuData(){
		return suhuData;
	}

	@Override
 	public String toString(){
		return 
			"DataKoiResponse{" + 
			"averageSuhu = '" + averageSuhu + '\'' + 
			",pHdata = '" + pHdata + '\'' +
			",averagepH = '" + averagepH + '\'' +
			",suhuData = '" + suhuData + '\'' +
			"}";
		}
}