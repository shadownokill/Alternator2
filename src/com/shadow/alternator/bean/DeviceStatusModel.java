package com.shadow.alternator.bean;

public class DeviceStatusModel {
	/// <summary>
    /// 状态编号
    /// </summary>
    public int status_id; //{ get; set; }
    /// <summary>
    /// 设备ID
    /// </summary>
    public int dev_id; //{ get; set; }
    /// <summary>
    /// 记录时间
    /// </summary>
    public String status_time; //{ get; set; }
    /// <summary>
    /// 转速传感器断线状态
    /// </summary>
    public int main_offline_rotarytrans; //{ get; set; }
    /// <summary>
    /// 油压传感器断线状态
    /// </summary>
    public int main_offline_oilpress; //{ get; set; }
    /// <summary>
    /// 综合报警灯
    /// </summary>
    public int led_comprehensive; //{ get; set; } 第五个 0-灰色 
    
    public int led_comprehensive_format;
    
    /// <summary>
    /// 机组正常灯闪标志
    /// </summary>
    public int led_flicker_normalunits; //{ get; set; }
    /// <summary>
    /// 市电正常灯闪标志
    /// </summary>
    public int led_flicker_normalmain; //{ get; set; }
    /// <summary>
    /// 综合报警正常闪标志
    /// </summary>
    // 0 灭 1 常亮 2常闪
    public int led_flicker_normalcomp; //{ get; set; } 第五个 闪烁  a =1 && b = 0 红灯常量  a =b = 1红灯常扇
    /// <summary>
    /// 停机灯
    /// </summary>
    public int led_stop; //{ get; set; } 第一个
    /// <summary>
    /// 手动灯
    /// </summary>
    public int led_manual; //{ get; set; } 第二个
    /// <summary>
    /// 自动灯
    /// </summary>
    public int led_auto; //{ get; set; } 第三个
    /// <summary>
    /// 测试灯
    /// </summary>
    public int led_test; //{ get; set; } 第四个
    
    //
    
    /// <summary>
    /// 发电机组正常灯
    /// </summary>
    public int led_normal_gen; //{ get; set; } 左上 1
    /// <summary>
    /// 机组合闸灯
    /// </summary>
    public int led_close_units; //{ get; set; } 左二 
    /// <summary>
    /// 市电合闸灯
    /// </summary>
    public int led_close_main; //{ get; set; } 右二
    /// <summary>
    /// 市电正常灯
    /// </summary>
    public int led_normal_main; //{ get; set; } 右上1
    /// <summary>
    /// 停机延时
    /// </summary>
    public int delay_stop; //{ get; set; }
    /// <summary>
    /// 停机散热延时
    /// </summary>
    public int delay_stop_radiate; //{ get; set; }
    /// <summary>
    /// 停机怠速延时
    /// </summary>
    public int delay_stop_idling; //{ get; set; }
    /// <summary>
    /// 等待稳停延时
    /// </summary>
    public int delay_stop_wait; //{ get; set; }
    /// <summary>
    /// 燃油输出延时
    /// </summary>
    public int delay_out_oil; //{ get; set; }
    /// <summary>
    /// 启动预热延时
    /// </summary>
    public int delay_boot_preheating; //{ get; set; }
    /// <summary>
    /// 正在启动
    /// </summary>
    public int being_start; //{ get; set; }
    /// <summary>
    /// 机组等待带载
    /// </summary>
    public int units_waitload; //{ get; set; }
    /// <summary>
    /// 开机怠速延时
    /// </summary>
    public int delay_start_idling; //{ get; set; }
    /// <summary>
    /// 暖机延时
    /// </summary>
    public int delay_warmup; //{ get; set; }
    /// <summary>
    /// 机组正常运行
    /// </summary>
    public int units_normalop; //{ get; set; }
    /// <summary>
    /// 开机延时
    /// </summary>
    public int delay_start; //{ get; set; }
    /// <summary>
    /// 启动间隔延时
    /// </summary>
    public int delay_start_interval; //{ get; set; }
    /// <summary>
    /// 市电正常鉴别
    /// </summary>
    public int main_nor_id; //{ get; set; }
    /// <summary>
    /// 市电异常鉴别
    /// </summary>
    public int main_abnor_id; //{ get; set; }
    /// <summary>
    /// 得电停机延时
    /// </summary>
    public int delay_powerdown; //{ get; set; }
    /// <summary>
    /// 失电自启动延时
    /// </summary>
    public int delay_loss_selfstart; //{ get; set; }
    /// <summary>
    /// 得电自停机延时
    /// </summary>
    public int delay_power_selfstop; //{ get; set; }
    /// <summary>
    /// 停机失败状态
    /// </summary>
    public int fail_stop; //{ get; set; }
    /// <summary>
    /// 警告状态
    /// </summary>
    public int alert_status; //{ get; set; }
    /// <summary>
    /// 报警停机状态
    /// </summary>
    public int stopalert_status; //{ get; set; }
    /// <summary>
    /// 安全运行延时
    /// </summary>
    public int delay_safeopt; //{ get; set; }
    /// <summary>
    /// 手动模式
    /// </summary>
    public int manual_mode; //{ get; set; }
    /// <summary>
    /// 自动模式
    /// </summary>
    public int auto_mode; //{ get; set; }
    /// <summary>
    /// 测试模式
    /// </summary>
    public int test_mode; //{ get; set; }
    /// <summary>
    /// 停机模式
    /// </summary>
    public int stop_mode; //{ get; set; }
    /// <summary>
    /// 开关转换延时
    /// </summary>
    public int delay_switch_conversion; //{ get; set; }
    /// <summary>
    /// 温度高报警停机
    /// </summary>
    public int stop_hightemp; //{ get; set; }
    /// <summary>
    /// 低油压报警停机
    /// </summary>
    public int stop_low_oilprs; //{ get; set; }
    /// <summary>
    /// 燃油位低报警停机
    /// </summary>
    public int stop_low_oillv; //{ get; set; }
    /// <summary>
    /// 停机失败警告
    /// </summary>
    public int alarm_failstop; //{ get; set; }
    /// <summary>
    /// 外部停机报警输入
    /// </summary>
    public int almin_outstop; //{ get; set; }
    /// <summary>
    /// 停机状态
    /// </summary>
    public int stopstatus; //{ get; set; }
    /// <summary>
    /// 启动成功状态
    /// </summary>
    public int status_suc_act; //{ get; set; }
    /// <summary>
    /// 发电机运行状态
    /// </summary>
    public int gen_run_status; //{ get; set; }
    /// <summary>
    /// 发电机组供电状态
    /// </summary>
    public int units_power_status; //{ get; set; }
    /// <summary>
    /// 发电机组停止状态
    /// </summary>
    public int units_stop_status; //{ get; set; }
    /// <summary>
    /// 市电停止状态
    /// </summary>
    public int main_stop_status; //{ get; set; }
    /// <summary>
    /// 市电运行状态
    /// </summary>
    public int main_run_status; //{ get; set; }
    /// <summary>
    /// 市电供电状态
    /// </summary>
    public int main_power_status; //{ get; set; }
}
