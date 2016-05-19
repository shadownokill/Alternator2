package com.shadow.alternator.bean;

public class DeviceBasicModel {

	// / <summary>
	// / 自增主键
	// / </summary>
	public int data_id;// { get; set; }
	// / <summary>
	// / 设备ID
	// / </summary>
	public int dev_id;// { get; set; }
	// / <summary>
	// / 上报时间
	// / </summary>
	public String data_time;// { get; set; }
	// / <summary>
	// / 市电AB线电压
	// / </summary>
	public int MAIN_VOLT_AB;// { get; set; }
	// / <summary>
	// / 市电BC线电压
	// / </summary>
	public int MAIN_VOLT_BC;// { get; set; }
	// / <summary>
	// / 市电CA线电压
	// / </summary>
	public int MAIN_VOLT_CA;// { get; set; }
	// / <summary>
	// / 市电A相电压
	// / </summary>
	public int MAIN_VOLT_A;// { get; set; }
	// / <summary>
	// / 市电B相电压
	// / </summary>
	public int MAIN_VOLT_B;// { get; set; }
	// / <summary>
	// / 市电C相电压
	// / </summary>
	public int MAIN_VOLT_C;// { get; set; }
	// / <summary>
	// / 油机AB线电压
	// / </summary>
	public int OIL_VOLT_AB;// { get; set; }
	// / <summary>
	// / 油机BC线电压
	// / </summary>
	public int OIL_VOLT_BC;// { get; set; }
	// / <summary>
	// / 油机CA线电压
	// / </summary>
	public int OIL_VOLT_CA;// { get; set; }
	// / <summary>
	// / 油机A相电压
	// / </summary>
	public int OIL_VOLT_A;// { get; set; }
	// / <summary>
	// / 油机B相电压
	// / </summary>
	public int OIL_VOLT_B;// { get; set; }
	// / <summary>
	// / 油机C相电压
	// / </summary>
	public int OIL_VOLT_C;// { get; set; }
	// / <summary>
	// / 油机A相电流
	// / </summary>
	public int OIL_CURRENT_A;// { get; set; }

	public String OIL_CURRENT_A_Format;

	// / <summary>
	// / 油机B相电流
	// / </summary>
	public int OIL_CURRENT_B;// { get; set; }

	public String OIL_CURRENT_B_Format;
	// / <summary>
	// / 油机C相电流
	// / </summary>
	public int OIL_CURRENT_C;// { get; set; }

	public String OIL_CURRENT_C_Format;
	// / <summary>
	// / 油机功率因数
	// / </summary>
	public int OIL_COS;// { get; set; }

	public String OIL_COS_Format;

	// / <summary>
	// / 市电频率
	// / </summary>
	public int MAIN_FREQ;// { get; set; }

	public String MAIN_FREQ_Format;
	// / <summary>
	// / 发电机频率
	// / </summary>
	public int GEN_FREQ;// { get; set; }

	public String GEN_FREQ_Format;
	// / <summary>
	// / 油机总有功功率
	// / </summary>
	public int OIL_ACTIVEPOWER_TOTAL;// { get; set; }

	public String OIL_ACTIVEPOWER_TOTAL_Format;
	// / <summary>
	// / 油机总视在功率
	// / </summary>
	public int OIL_APPARENTPOWER_TOTAL;// { get; set; }

	public String OIL_APPARENTPOWER_TOTAL_Format;

	// / <summary>
	// / 油机总无功功率
	// / </summary>
	public int OIL_REACTIVEPOWER_TOTAL;// { get; set; }

	public String OIL_REACTIVEPOWER_TOTAL_Format;
	// / <summary>
	// / 油机A相有功功率
	// / </summary>
	public int OIL_ACTIVEPOWER_A;// { get; set; }

	public String OIL_ACTIVEPOWER_A_Format;

	// / <summary>
	// / 油机B相有功功率
	// / </summary>
	public int OIL_ACTIVEPOWER_B;// { get; set; }

	public String OIL_ACTIVEPOWER_B_Format;
	// / <summary>
	// / 油机C相有功功率
	// / </summary>
	public int OIL_ACTIVEPOWER_C;// { get; set; }

	public String OIL_ACTIVEPOWER_C_Format;

	// / <summary>
	// / 油机A相无功功率
	// / </summary>
	public int OIL_REACTIVEPOWER_A;// { get; set; }

	public String OIL_REACTIVEPOWER_A_Format;
	// / <summary>
	// / 油机B相无功功率
	// / </summary>
	public int OIL_REACTIVEPOWER_B;// { get; set; }

	public String OIL_REACTIVEPOWER_A_Format_Format;
	// / <summary>
	// / 油机C相无功功率
	// / </summary>
	public int OIL_REACTIVEPOWER_C;// { get; set; }

	public String OIL_REACTIVEPOWER_C_Format;
	// / <summary>
	// / 油机A相视在功率
	// / </summary>
	public int OIL_APPARENTPOWER_A;// { get; set; }

	public String OIL_APPARENTPOWER_A_Format;
	// / <summary>
	// / 油机B相视在功率
	// / </summary>
	public int OIL_APPARENTPOWER_B;// { get; set; }

	public String OIL_APPARENTPOWER_B_Format;
	// / <summary>
	// / 油机C相视在功率
	// / </summary>
	public int OIL_APPARENTPOWER_C;// { get; set; }

	public String OIL_APPARENTPOWER_C_Format;
	// / <summary>
	// / 油机A相功率因数
	// / </summary>
	public int OIL_COS_A;// { get; set; }

	public String OIL_COS_A_Format;
	// / <summary>
	// / 油机B相功率因数
	// / </summary>
	public int OIL_COS_B;// { get; set; }

	public String OIL_COS_B_Format;
	// / <summary>
	// / 油机C相功率因数
	// / </summary>
	public int OIL_COS_C;// { get; set; }

	public String OIL_COS_C_Format;

	// / <summary>
	// / 水温 -32768=断线
	// / </summary>
	public int DES_WATER_TEMP;// { get; set; }
	// / <summary>
	// / 油位 -32768=断线
	// / </summary>
	public int DES_FUEL_LEVEL;// { get; set; }
	// / <summary>
	// / 油压
	// / </summary>
	public int DES_LUB_PREESURE;// { get; set; }

	public String DES_LUB_PREESURE_Format;
	// / <summary>
	// / 油温 -32768=断线
	// / </summary>
	public int DES_LUB_TEMP;// { get; set; }

	// / <summary>
	// / 电池电压
	// / </summary>
	public int DES_BATT_VOLT;// { get; set; }

	public String DES_BATT_VOLT_Format;
	// / <summary>
	// / 充电机电压
	// / </summary>
	public int DES_CHARGE_VOLT;// { get; set; }

	public String DES_CHARGE_VOLT_Format;
	// / <summary>
	// / 油机转速
	// / </summary>
	public int DES_SPEED;// { get; set; }
	// / <summary>
	// / 油机千瓦时高位
	// / </summary>
	public int OIL_KWH_HIGH;// { get; set; }
	// / <summary>
	// / 油机千瓦时低位
	// / </summary>
	public int OIL_KWH_LOW;// { get; set; }

	public String OIL_KWH_Total_Format;
	// / <summary>
	// / 油机千乏时高位
	// / </summary>
	public int GEN_KWH_HIGH;// { get; set; }
	// / <summary>
	// / 油机千乏时低位
	// / </summary>
	public int GEN_KWH_LOW;// { get; set; }

	public String GEN_KWH_Total_Format;

	// / <summary>
	// / 油机运行累时
	// / </summary>
	public int OIL_DES_HOUR;// { get; set; }
	// / <summary>
	// / 油机运行累分
	// / </summary>
	public int OIL_DES_MIN;// { get; set; }
	// / <summary>
	// / 油机运行累秒
	// / </summary>
	public int OIL_DES_SEC;// { get; set; }
	// / <summary>
	// / 油机累计开机次数
	// / </summary>
	public int OIL_CBT;// { get; set; }

}
