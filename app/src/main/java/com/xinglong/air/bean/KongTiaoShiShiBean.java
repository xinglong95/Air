package com.xinglong.air.bean;

import com.citzx.cslibrary.utils.MTextUtils;

public class KongTiaoShiShiBean {

    /**
     * data : {"id":"AC2017090002","ModeOne":"4","ModeTwo":"0","LACSetTemp":"0","INAIR_T_10AD_2_A":"01","INAIR_T_10AD_1_A":"D0","INAIR_T":24,"OUTAIR_T":"26","PM25":"15","CO2_Value":"0","Temperature_A_T":"27","HumidityValue_A":"0","RunningFrequencyInFan":"47","RunningFrequencyOFan":"0","FreshValveNow":"0","FreshValveBNow":"0","AirEeleNums":"0","RoomEeleNums":"0","ReflowValveNow":"36","ReflowValveBNow":"0","IndoorHeat_A_T":"25","HEAT_A_T":"24","RunningFrequencyCompA":"0","DISCHARGE_A_T":"24","Exv1TargetDischargeTemp_T":"49","F_LIMIT_R_A":"0","InverterLimit_FCompA":"1","V1_NOW_STATE_RDIV256":"1","V1_NOW_STATE_RMOD256":"244","V1_NOW_STATE":"500","High_Pressure_A":"0","Low_Pressure_A":"0","CompA_ControlCommand":"0","ErrCodeA":"0","IndoorHeat_B_T":"25","HEAT_B_T":"24","RunningFrequencyCompB":"0","CompBTargetFrequency":"0","DISCHARGE_B_T":"24","Exv2TargetDischargeTemp_T":"49","F_LIMIT_R_B":"0","InverterLimit_FCompB":"1","V2_NOW_STATE_RDIV256":"1","V2_NOW_STATE_RMOD256":"244","V2_NOW_STATE":"500","High_Pressure_B":"0","Low_Pressure_B":"0","CompB_ControlCommand":"0","ErrCodeB":"0","Errcode":"0","OnLine":1}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : AC2017090002
         * ModeOne : 4
         * ModeTwo : 0
         * LACSetTemp : 0
         * INAIR_T_10AD_2_A : 01
         * INAIR_T_10AD_1_A : D0
         * INAIR_T : 24
         * OUTAIR_T : 26
         * PM25 : 15
         * CO2_Value : 0
         * Temperature_A_T : 27
         * HumidityValue_A : 0
         * RunningFrequencyInFan : 47
         * RunningFrequencyOFan : 0
         * FreshValveNow : 0
         * FreshValveBNow : 0
         * AirEeleNums : 0
         * RoomEeleNums : 0
         * ReflowValveNow : 36
         * ReflowValveBNow : 0
         * IndoorHeat_A_T : 25
         * HEAT_A_T : 24
         * RunningFrequencyCompA : 0
         * DISCHARGE_A_T : 24
         * Exv1TargetDischargeTemp_T : 49
         * F_LIMIT_R_A : 0
         * InverterLimit_FCompA : 1
         * V1_NOW_STATE_RDIV256 : 1
         * V1_NOW_STATE_RMOD256 : 244
         * V1_NOW_STATE : 500
         * High_Pressure_A : 0
         * Low_Pressure_A : 0
         * CompA_ControlCommand : 0
         * ErrCodeA : 0
         * IndoorHeat_B_T : 25
         * HEAT_B_T : 24
         * RunningFrequencyCompB : 0
         * CompBTargetFrequency : 0
         * DISCHARGE_B_T : 24
         * Exv2TargetDischargeTemp_T : 49
         * F_LIMIT_R_B : 0
         * InverterLimit_FCompB : 1
         * V2_NOW_STATE_RDIV256 : 1
         * V2_NOW_STATE_RMOD256 : 244
         * V2_NOW_STATE : 500
         * High_Pressure_B : 0
         * Low_Pressure_B : 0
         * CompB_ControlCommand : 0
         * ErrCodeB : 0
         * Errcode : 0
         * OnLine : 1
         */

        private String id;
        private String ModeOne;
        private String ModeTwo;
        private String LACSetTemp;
        private String INAIR_T_10AD_2_A;
        private String INAIR_T_10AD_1_A;
        private int INAIR_T;
        private String OUTAIR_T;
        private String PM25;
        private String CO2_Value;
        private String Temperature_A_T;
        private String HumidityValue_A;
        private String RunningFrequencyInFan;
        private String RunningFrequencyOFan;
        private String FreshValveNow;
        private String FreshValveBNow;
        private String AirEeleNums;
        private String RoomEeleNums;
        private String ReflowValveNow;
        private String ReflowValveBNow;
        private String IndoorHeat_A_T;
        private String HEAT_A_T;
        private String RunningFrequencyCompA;
        private String DISCHARGE_A_T;
        private String Exv1TargetDischargeTemp_T;
        private String F_LIMIT_R_A;
        private String InverterLimit_FCompA;
        private String V1_NOW_STATE_RDIV256;
        private String V1_NOW_STATE_RMOD256;
        private String V1_NOW_STATE;
        private String High_Pressure_A;
        private String Low_Pressure_A;
        private String CompA_ControlCommand;
        private String ErrCodeA;
        private String IndoorHeat_B_T;
        private String HEAT_B_T;
        private String RunningFrequencyCompB;
        private String CompBTargetFrequency;
        private String DISCHARGE_B_T;
        private String Exv2TargetDischargeTemp_T;
        private String F_LIMIT_R_B;
        private String InverterLimit_FCompB;
        private String V2_NOW_STATE_RDIV256;
        private String V2_NOW_STATE_RMOD256;
        private String V2_NOW_STATE;
        private String High_Pressure_B;
        private String Low_Pressure_B;
        private String CompB_ControlCommand;
        private String ErrCodeB;
        private String Errcode;
        private int OnLine;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getModeOne() {
            return ModeOne;
        }
        public String getModeOneText() {
            String mode_str="";
            if (MTextUtils.notEmpty(ModeOne)){
                switch (ModeOne){
                    case "0":
                        mode_str="通风";
                        break;
                    case "1":
                        mode_str="自动暖";
                        break;
                    case "2":
                        mode_str="自动冷";
                        break;
                    case "3":
                        mode_str="半冷";
                        break;
                    case "4":
                        mode_str="制冷";
                        break;
                    case "5":
                        mode_str="半暖";
                        break;
                    case "6":
                        mode_str="制暖";
                        break;
                    case "7":
                        mode_str="停";
                        break;
                    default:
                        mode_str="无数据";
                        break;
                }
            }
            return mode_str;
        }
        public void setModeOne(String ModeOne) {
            this.ModeOne = ModeOne;
        }

        public String getModeTwo() {
            return ModeTwo;
        }

        public void setModeTwo(String ModeTwo) {
            this.ModeTwo = ModeTwo;
        }

        public String getLACSetTemp() {
            return LACSetTemp;
        }

        public void setLACSetTemp(String LACSetTemp) {
            this.LACSetTemp = LACSetTemp;
        }

        public String getINAIR_T_10AD_2_A() {
            return INAIR_T_10AD_2_A;
        }

        public void setINAIR_T_10AD_2_A(String INAIR_T_10AD_2_A) {
            this.INAIR_T_10AD_2_A = INAIR_T_10AD_2_A;
        }

        public String getINAIR_T_10AD_1_A() {
            return INAIR_T_10AD_1_A;
        }

        public void setINAIR_T_10AD_1_A(String INAIR_T_10AD_1_A) {
            this.INAIR_T_10AD_1_A = INAIR_T_10AD_1_A;
        }

        public int getINAIR_T() {
            return INAIR_T;
        }

        public void setINAIR_T(int INAIR_T) {
            this.INAIR_T = INAIR_T;
        }

        public String getOUTAIR_T() {
            return OUTAIR_T;
        }

        public void setOUTAIR_T(String OUTAIR_T) {
            this.OUTAIR_T = OUTAIR_T;
        }

        public String getPM25() {
            return PM25;
        }

        public void setPM25(String PM25) {
            this.PM25 = PM25;
        }

        public String getCO2_Value() {
            return CO2_Value;
        }

        public void setCO2_Value(String CO2_Value) {
            this.CO2_Value = CO2_Value;
        }

        public String getTemperature_A_T() {
            return Temperature_A_T;
        }

        public void setTemperature_A_T(String Temperature_A_T) {
            this.Temperature_A_T = Temperature_A_T;
        }

        public String getHumidityValue_A() {
            return HumidityValue_A;
        }

        public void setHumidityValue_A(String HumidityValue_A) {
            this.HumidityValue_A = HumidityValue_A;
        }

        public String getRunningFrequencyInFan() {
            return RunningFrequencyInFan;
        }

        public void setRunningFrequencyInFan(String RunningFrequencyInFan) {
            this.RunningFrequencyInFan = RunningFrequencyInFan;
        }

        public String getRunningFrequencyOFan() {
            return RunningFrequencyOFan;
        }

        public void setRunningFrequencyOFan(String RunningFrequencyOFan) {
            this.RunningFrequencyOFan = RunningFrequencyOFan;
        }

        public String getFreshValveNow() {
            return FreshValveNow;
        }

        public void setFreshValveNow(String FreshValveNow) {
            this.FreshValveNow = FreshValveNow;
        }

        public String getFreshValveBNow() {
            return FreshValveBNow;
        }

        public void setFreshValveBNow(String FreshValveBNow) {
            this.FreshValveBNow = FreshValveBNow;
        }

        public String getAirEeleNums() {
            return AirEeleNums;
        }

        public void setAirEeleNums(String AirEeleNums) {
            this.AirEeleNums = AirEeleNums;
        }

        public String getRoomEeleNums() {
            return RoomEeleNums;
        }

        public void setRoomEeleNums(String RoomEeleNums) {
            this.RoomEeleNums = RoomEeleNums;
        }

        public String getReflowValveNow() {
            return ReflowValveNow;
        }

        public void setReflowValveNow(String ReflowValveNow) {
            this.ReflowValveNow = ReflowValveNow;
        }

        public String getReflowValveBNow() {
            return ReflowValveBNow;
        }

        public void setReflowValveBNow(String ReflowValveBNow) {
            this.ReflowValveBNow = ReflowValveBNow;
        }

        public String getIndoorHeat_A_T() {
            return IndoorHeat_A_T;
        }

        public void setIndoorHeat_A_T(String IndoorHeat_A_T) {
            this.IndoorHeat_A_T = IndoorHeat_A_T;
        }

        public String getHEAT_A_T() {
            return HEAT_A_T;
        }

        public void setHEAT_A_T(String HEAT_A_T) {
            this.HEAT_A_T = HEAT_A_T;
        }

        public String getRunningFrequencyCompA() {
            return RunningFrequencyCompA;
        }

        public void setRunningFrequencyCompA(String RunningFrequencyCompA) {
            this.RunningFrequencyCompA = RunningFrequencyCompA;
        }

        public String getDISCHARGE_A_T() {
            return DISCHARGE_A_T;
        }

        public void setDISCHARGE_A_T(String DISCHARGE_A_T) {
            this.DISCHARGE_A_T = DISCHARGE_A_T;
        }

        public String getExv1TargetDischargeTemp_T() {
            return Exv1TargetDischargeTemp_T;
        }

        public void setExv1TargetDischargeTemp_T(String Exv1TargetDischargeTemp_T) {
            this.Exv1TargetDischargeTemp_T = Exv1TargetDischargeTemp_T;
        }

        public String getF_LIMIT_R_A() {
            return F_LIMIT_R_A;
        }

        public void setF_LIMIT_R_A(String F_LIMIT_R_A) {
            this.F_LIMIT_R_A = F_LIMIT_R_A;
        }

        public String getInverterLimit_FCompA() {
            return InverterLimit_FCompA;
        }

        public void setInverterLimit_FCompA(String InverterLimit_FCompA) {
            this.InverterLimit_FCompA = InverterLimit_FCompA;
        }

        public String getV1_NOW_STATE_RDIV256() {
            return V1_NOW_STATE_RDIV256;
        }

        public void setV1_NOW_STATE_RDIV256(String V1_NOW_STATE_RDIV256) {
            this.V1_NOW_STATE_RDIV256 = V1_NOW_STATE_RDIV256;
        }

        public String getV1_NOW_STATE_RMOD256() {
            return V1_NOW_STATE_RMOD256;
        }

        public void setV1_NOW_STATE_RMOD256(String V1_NOW_STATE_RMOD256) {
            this.V1_NOW_STATE_RMOD256 = V1_NOW_STATE_RMOD256;
        }

        public String getV1_NOW_STATE() {
            return V1_NOW_STATE;
        }

        public void setV1_NOW_STATE(String V1_NOW_STATE) {
            this.V1_NOW_STATE = V1_NOW_STATE;
        }

        public String getHigh_Pressure_A() {
            return High_Pressure_A;
        }

        public void setHigh_Pressure_A(String High_Pressure_A) {
            this.High_Pressure_A = High_Pressure_A;
        }

        public String getLow_Pressure_A() {
            return Low_Pressure_A;
        }

        public void setLow_Pressure_A(String Low_Pressure_A) {
            this.Low_Pressure_A = Low_Pressure_A;
        }

        public String getCompA_ControlCommand() {
            return CompA_ControlCommand;
        }

        public void setCompA_ControlCommand(String CompA_ControlCommand) {
            this.CompA_ControlCommand = CompA_ControlCommand;
        }

        public String getErrCodeA() {
            return ErrCodeA;
        }

        public void setErrCodeA(String ErrCodeA) {
            this.ErrCodeA = ErrCodeA;
        }

        public String getIndoorHeat_B_T() {
            return IndoorHeat_B_T;
        }

        public void setIndoorHeat_B_T(String IndoorHeat_B_T) {
            this.IndoorHeat_B_T = IndoorHeat_B_T;
        }

        public String getHEAT_B_T() {
            return HEAT_B_T;
        }

        public void setHEAT_B_T(String HEAT_B_T) {
            this.HEAT_B_T = HEAT_B_T;
        }

        public String getRunningFrequencyCompB() {
            return RunningFrequencyCompB;
        }

        public void setRunningFrequencyCompB(String RunningFrequencyCompB) {
            this.RunningFrequencyCompB = RunningFrequencyCompB;
        }

        public String getCompBTargetFrequency() {
            return CompBTargetFrequency;
        }

        public void setCompBTargetFrequency(String CompBTargetFrequency) {
            this.CompBTargetFrequency = CompBTargetFrequency;
        }

        public String getDISCHARGE_B_T() {
            return DISCHARGE_B_T;
        }

        public void setDISCHARGE_B_T(String DISCHARGE_B_T) {
            this.DISCHARGE_B_T = DISCHARGE_B_T;
        }

        public String getExv2TargetDischargeTemp_T() {
            return Exv2TargetDischargeTemp_T;
        }

        public void setExv2TargetDischargeTemp_T(String Exv2TargetDischargeTemp_T) {
            this.Exv2TargetDischargeTemp_T = Exv2TargetDischargeTemp_T;
        }

        public String getF_LIMIT_R_B() {
            return F_LIMIT_R_B;
        }

        public void setF_LIMIT_R_B(String F_LIMIT_R_B) {
            this.F_LIMIT_R_B = F_LIMIT_R_B;
        }

        public String getInverterLimit_FCompB() {
            return InverterLimit_FCompB;
        }

        public void setInverterLimit_FCompB(String InverterLimit_FCompB) {
            this.InverterLimit_FCompB = InverterLimit_FCompB;
        }

        public String getV2_NOW_STATE_RDIV256() {
            return V2_NOW_STATE_RDIV256;
        }

        public void setV2_NOW_STATE_RDIV256(String V2_NOW_STATE_RDIV256) {
            this.V2_NOW_STATE_RDIV256 = V2_NOW_STATE_RDIV256;
        }

        public String getV2_NOW_STATE_RMOD256() {
            return V2_NOW_STATE_RMOD256;
        }

        public void setV2_NOW_STATE_RMOD256(String V2_NOW_STATE_RMOD256) {
            this.V2_NOW_STATE_RMOD256 = V2_NOW_STATE_RMOD256;
        }

        public String getV2_NOW_STATE() {
            return V2_NOW_STATE;
        }

        public void setV2_NOW_STATE(String V2_NOW_STATE) {
            this.V2_NOW_STATE = V2_NOW_STATE;
        }

        public String getHigh_Pressure_B() {
            return High_Pressure_B;
        }

        public void setHigh_Pressure_B(String High_Pressure_B) {
            this.High_Pressure_B = High_Pressure_B;
        }

        public String getLow_Pressure_B() {
            return Low_Pressure_B;
        }

        public void setLow_Pressure_B(String Low_Pressure_B) {
            this.Low_Pressure_B = Low_Pressure_B;
        }

        public String getCompB_ControlCommand() {
            return CompB_ControlCommand;
        }

        public void setCompB_ControlCommand(String CompB_ControlCommand) {
            this.CompB_ControlCommand = CompB_ControlCommand;
        }

        public String getErrCodeB() {
            return ErrCodeB;
        }

        public void setErrCodeB(String ErrCodeB) {
            this.ErrCodeB = ErrCodeB;
        }

        public String getErrcode() {
            return Errcode;
        }

        public void setErrcode(String Errcode) {
            this.Errcode = Errcode;
        }

        public int getOnLine() {
            return OnLine;
        }

        public void setOnLine(int OnLine) {
            this.OnLine = OnLine;
        }
    }
}
