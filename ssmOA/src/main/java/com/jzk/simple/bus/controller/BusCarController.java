package com.jzk.simple.bus.controller;

import com.jzk.simple.bus.domain.BusCar;
import com.jzk.simple.bus.service.BusCarService;
import com.jzk.simple.bus.vo.BusCarVo;
import com.jzk.simple.sys.constast.SysConstast;
import com.jzk.simple.sys.utils.AppFileUtils;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * ClassName:BusCarController
 * Package:com.jzk.simple.bus.controller
 * Description:
 *
 * @Date:2020/5/9 15:17
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("car")
public class BusCarController {

    @Autowired
    private BusCarService busCarService;

    @ResponseBody
    @RequestMapping("loadAllCar")
    public DataGridView loadAllCar(BusCarVo busCarVo){
        return this.busCarService.queryAllCar(busCarVo);
    }

    @ResponseBody
    @RequestMapping("addCar")
    public ResultObj addCar(BusCarVo busCar){
        try {
            busCar.setCreatetime(new Date());
            if(!busCar.getCarimg().equals(SysConstast.DEFAULT_CAR_IMG)){
                String filePath=
                        AppFileUtils.updateFileName(busCar.getCarimg(),SysConstast.FILE_UPLOAD_TEMP);
                busCar.setCarimg(filePath);
            }
            this.busCarService.addCar(busCar);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("updateCar")
    public ResultObj updateCar(BusCarVo busCarVo){
        try {
            String carImg=busCarVo.getCarimg();
            if (carImg.endsWith(SysConstast.FILE_UPLOAD_TEMP)){
                String filePath=
                        AppFileUtils.updateFileName(busCarVo.getCarimg(),SysConstast.FILE_UPLOAD_TEMP);
                busCarVo.setCarimg(filePath);
                BusCar busCar=this.busCarService.queryCarByCarNumber(busCarVo.getCarnumber());
                AppFileUtils.removeFileByPath(busCar.getCarimg());
            }
            this.busCarService.updateCar(busCarVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
}
