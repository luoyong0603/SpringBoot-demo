package com.example.demo.vo.ExcelUser;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.demo.entity.LogInfo;
import com.example.demo.entity.UserEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * excel导出logInfo参数
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/2/21 14:34
 */
@Data
public class ExportExcelLog implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * @Excel 作用在一个filed上面，对列的描述
     * @param name 列名
     * @param orderNum 下标，从0开始。
     */
    @Excel(name = "url", width = 20.0)
    private String url;

    @Excel(name = "ip", width = 20.0)
    private String ip;

    //字段是Date类型则不需要设置databaseFormat
    @Excel(name = "请求时间", format = "yyyy-MM-dd", width = 20.0)
    private Date operationTime;

    @Excel(name = "接口返回状态码", width = 20.0)
    private int code;

    public ExportExcelLog() {

    }

    /**
     * 构造函数
     */
    public ExportExcelLog(LogInfo log) {
        //赋值
        this.ip = log.getIp();
        this.code = log.getResponseCode();
        this.operationTime = log.getOperateTime();
        this.url = log.getUrl();
    }

}
