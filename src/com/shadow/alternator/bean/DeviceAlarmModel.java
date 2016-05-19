package com.shadow.alternator.bean;

public class DeviceAlarmModel {

    /// <summary>
    /// 报警编号
    /// </summary>
    public int alarm_id;// { get; set; }
    /// <summary>
    /// 设备编号
    /// </summary>
    public int dev_id;// { get; set; }
    /// <summary>
    /// 报警时间
    /// </summary>
    public String alarm_time;// { get; set; }
    /// <summary>
    /// 油压低
    /// </summary>
    public int des_low_oilprs;// { get; set; }
    /// <summary>
    /// 维护报警
    /// </summary>
    public int des_maint;// { get; set; }
    /// <summary>
    /// 紧急停机报警
    /// </summary>
    public int des_stop_urgent;// { get; set; }
    /// <summary>
    /// 温度高停机报警
    /// </summary>
    public int des_stop_hot;// { get; set; }
    /// <summary>
    /// 油压低停机报警
    /// </summary>
    public int des_stop_lowoil;// { get; set; }
    /// <summary>
    /// 超速停机报警
    /// </summary>
    public int des_stop_overspeed;// { get; set; }
    /// <summary>
    /// 欠速停机报警
    /// </summary>
    public int des_stop_underspeed;// { get; set; }
    /// <summary>
    /// 失速报警
    /// </summary>
    public int des_lossspeed;// { get; set; }
    /// <summary>
    /// 速度丢失警报
    /// </summary>
    public int des_lostspeed_stop;// { get; set; }
    /// <summary>
    /// 停机失败报警
    /// </summary>
    public int des_stop_fail;// { get; set; }
    /// <summary>
    /// 燃油位低报警
    /// </summary>
    public int des_oillev_low;// { get; set; }
    /// <summary>
    /// 充电失败报警
    /// </summary>
    public int des_charge_fail;// { get; set; }
    /// <summary>
    /// 电池电压低报警
    /// </summary>
    public int des_vbat_low;// { get; set; }
    /// <summary>
    /// 电池电压高报警
    /// </summary>
    public int des_vbat_high;// { get; set; }
    /// <summary>
    /// 温度高报警
    /// </summary>
    public int des_temp_high;// { get; set; }
    /// <summary>
    /// 温度传感器断线警告
    /// </summary>
    public int des_tempoffline;// { get; set; }
    /// <summary>
    /// 油压传感器断线警告
    /// </summary>
    public int des_oiloffline;// { get; set; }
    /// <summary>
    /// 启动失败报警
    /// </summary>
    public int des_start_fail;// { get; set; }
    /// <summary>
    /// 燃油位低停机报警
    /// </summary>
    public int des_stop_oillow;// { get; set; }
    /// <summary>
    /// 燃油位低停机报警
    /// </summary>
    public int des_stop_watarlow;// { get; set; }
    /// <summary>
    /// 温度断线停机报警
    /// </summary>
    public int des_stop_tempoffline;// { get; set; }
    /// <summary>
    /// 油压断线停机报警
    /// </summary>
    public int des_stop_oiloffline;// { get; set; }
    /// <summary>
    /// 维护停机报警
    /// </summary>
    public int des_stop_maint;// { get; set; }
    /// <summary>
    /// 外部报警
    /// </summary>
    public int des_outside;// { get; set; }
    /// <summary>
    /// 外部停机报警
    /// </summary>
    public int des_stop_outside;// { get; set; }
    /// <summary>
    /// 发电机过流报警
    /// </summary>
    public int gen_over_current;// { get; set; }
    /// <summary>
    /// 发电机过压报警
    /// </summary>
    public int gen_over_volt;// { get; set; }
    /// <summary>
    /// 发电机过流停机报警
    /// </summary>
    public int gen_stop_overcur;// { get; set; }
    /// <summary>
    /// 发电机频率高停机报警
    /// </summary>
    public int gen_stop_highfreq;// { get; set; }
    /// <summary>
    /// 发电机频率低停机报警
    /// </summary>
    public int gen_stop_lowfreq;// { get; set; }
    /// <summary>
    /// 发电机无发电机停机报警
    /// </summary>
    public int gen_stop_nonegen;// { get; set; }
    /// <summary>
    /// 油压传感器断线停机报警
    /// </summary>
    public int main_stop_oilpressoffline;// { get; set; }
    /// <summary>
    /// 市电电压高报警
    /// </summary>
    public int main_volt_high;// { get; set; }
    /// <summary>
    /// 市电电压低报警
    /// </summary>
    public int main_volt_low;// { get; set; }
    /// <summary>
    /// 滤清维护时间到报警
    /// </summary>
    public int main_urgent_timeover;// { get; set; }
    /// <summary>
    /// 转速传感器断线报警
    /// </summary>
    public int main_offline_rotarytrans;// { get; set; }
    /// <summary>
    /// 转速传感器断线停机报警
    /// </summary>
    public int main_stop_offrottrans;// { get; set; }
    /// <summary>
    /// 油压传感器断线报警
    /// </summary>
    public int main_offline_oilpress;// { get; set; }
 
}
