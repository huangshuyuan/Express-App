package com.hsy.express.bean;

import java.util.List;

/**
 * Author: syhuang
 * Date:  2017/12/26
 */

public class DeliveryBean {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"mailNo":"535962308717","update":1514268588375,"updateStr":"2017-12-26 14:09:48","ret_code":0,"flag":true,"dataSize":9,"status":4,"tel":"021-39777777","expSpellName":"zhongtong","data":[{"time":"2017-08-20 17:22:37","context":"[重庆市] [重庆黔江]的派件已签收 感谢使用中通快递,期待再次为您服务!"},{"time":"2017-08-20 16:39:34","context":"[重庆市] [重庆黔江]的阳光花园物业配送中心正在第1次派件 电话:暂无 请保持电话畅通、耐心等待"},{"time":"2017-08-20 15:51:49","context":"[重庆市] 快件到达 [重庆黔江]"},{"time":"2017-08-20 03:47:27","context":"[重庆市] 快件离开 [重庆]已发往[重庆黔江]"},{"time":"2017-08-19 09:17:19","context":"[漯河市] 快件到达 [漯河中转]"},{"time":"2017-08-17 23:39:27","context":"[郑州市] 快件离开 [郑州中转]已发往[重庆中转]"},{"time":"2017-08-17 23:37:09","context":"[郑州市] 快件到达 [郑州]"},{"time":"2017-08-17 20:09:21","context":"[郑州市] 快件离开 [郑州宇通]已发往[重庆]"},{"time":"2017-08-17 16:31:34","context":"[郑州市] [郑州宇通]的陈永军18703650762已收件 电话:18703650762"}],"expTextName":"中通快递","msg":"查询成功!"}
     */

    private int                showapi_res_code;
    private String             showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * mailNo : 535962308717
         * update : 1514268588375
         * updateStr : 2017-12-26 14:09:48
         * ret_code : 0
         * flag : true
         * dataSize : 9
         * status : 4
         * tel : 021-39777777
         * expSpellName : zhongtong
         * data : [{"time":"2017-08-20 17:22:37","context":"[重庆市] [重庆黔江]的派件已签收 感谢使用中通快递,期待再次为您服务!"},{"time":"2017-08-20 16:39:34","context":"[重庆市] [重庆黔江]的阳光花园物业配送中心正在第1次派件 电话:暂无 请保持电话畅通、耐心等待"},{"time":"2017-08-20 15:51:49","context":"[重庆市] 快件到达 [重庆黔江]"},{"time":"2017-08-20 03:47:27","context":"[重庆市] 快件离开 [重庆]已发往[重庆黔江]"},{"time":"2017-08-19 09:17:19","context":"[漯河市] 快件到达 [漯河中转]"},{"time":"2017-08-17 23:39:27","context":"[郑州市] 快件离开 [郑州中转]已发往[重庆中转]"},{"time":"2017-08-17 23:37:09","context":"[郑州市] 快件到达 [郑州]"},{"time":"2017-08-17 20:09:21","context":"[郑州市] 快件离开 [郑州宇通]已发往[重庆]"},{"time":"2017-08-17 16:31:34","context":"[郑州市] [郑州宇通]的陈永军18703650762已收件 电话:18703650762"}]
         * expTextName : 中通快递
         * msg : 查询成功!
         */

        private String         mailNo;
        private long           update;
        private String         updateStr;
        private int            ret_code;
        private boolean        flag;
        private int            dataSize;
        private int            status;
        private String         tel;
        private String         expSpellName;
        private String         expTextName;
        private String         msg;
        private List<DataBean> data;

        public String getMailNo() {
            return mailNo;
        }

        public void setMailNo(String mailNo) {
            this.mailNo = mailNo;
        }

        public long getUpdate() {
            return update;
        }

        public void setUpdate(long update) {
            this.update = update;
        }

        public String getUpdateStr() {
            return updateStr;
        }

        public void setUpdateStr(String updateStr) {
            this.updateStr = updateStr;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public int getDataSize() {
            return dataSize;
        }

        public void setDataSize(int dataSize) {
            this.dataSize = dataSize;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getExpSpellName() {
            return expSpellName;
        }

        public void setExpSpellName(String expSpellName) {
            this.expSpellName = expSpellName;
        }

        public String getExpTextName() {
            return expTextName;
        }

        public void setExpTextName(String expTextName) {
            this.expTextName = expTextName;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * time : 2017-08-20 17:22:37
             * context : [重庆市] [重庆黔江]的派件已签收 感谢使用中通快递,期待再次为您服务!
             */

            private String time;
            private String context;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getContext() {
                return context;
            }

            public void setContext(String context) {
                this.context = context;
            }
        }
    }
}
