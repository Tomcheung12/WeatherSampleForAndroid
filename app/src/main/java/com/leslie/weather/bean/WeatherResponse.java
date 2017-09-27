package com.leslie.weather.bean;

import java.util.List;

/**
 * Created date: 2017/8/7
 * Author:  Leslie
 * 天气预报接口返回的 XML 数据转换成 JSON 数据然后再转换成 bean 对象.
 * 数据源：/app/free_data.xml
 */

public class WeatherResponse {

    /**
     * resp : {"city":"济南","updatetime":"17:09","wendu":34,"fengli":"3级","shidu":"49%","fengxiang":"东风","sunrise_1":"05:19","sunset_1":"19:15","sunrise_2":"","sunset_2":"","environment":{"aqi":95,"pm25":66,"suggest":"极少数敏感人群应减少户外活动","quality":"良","MajorPollutants":"颗粒物(PM10)","o3":164,"co":1,"pm10":138,"so2":18,"no2":35,"time":"12:00:00"},"yesterday":{"date_1":"3日星期四","high_1":"高温 31℃","low_1":"低温 25℃","day_1":{"type_1":"多云","fx_1":"南风","fl_1":"微风"},"night_1":{"type_1":"多云","fx_1":"南风","fl_1":"微风"}},"forecast":{"weather":[{"date":"4日星期五","high":"高温 35℃","low":"低温 25℃","day":{"type":"晴","fengxiang":"南风","fengli":"微风级"},"night":{"type":"晴","fengxiang":"南风","fengli":"微风级"}},{"date":"5日星期六","high":"高温 35℃","low":"低温 26℃","day":{"type":"晴","fengxiang":"东北风","fengli":"微风级"},"night":{"type":"晴","fengxiang":"东南风","fengli":"微风级"}},{"date":"6日星期天","high":"高温 34℃","low":"低温 24℃","day":{"type":"多云","fengxiang":"东北风","fengli":"微风级"},"night":{"type":"晴","fengxiang":"东北风","fengli":"微风级"}},{"date":"7日星期一","high":"高温 34℃","low":"低温 26℃","day":{"type":"多云","fengxiang":"东北风","fengli":"微风级"},"night":{"type":"多云","fengxiang":"北风","fengli":"微风级"}},{"date":"8日星期二","high":"高温 34℃","low":"低温 23℃","day":{"type":"多云","fengxiang":"南风","fengli":"微风级"},"night":{"type":"多云","fengxiang":"南风","fengli":"微风级"}}]},"zhishus":{"zhishu":[{"name":"晨练指数","value":"较适宜","detail":"早晨气象条件较适宜晨练，注意选择通风凉爽的地点。适量饮水以及时补充体内水分。"},{"name":"舒适度","value":"很不舒适","detail":"白天天气晴好，但烈日炎炎会使您会感到很热，很不舒适。"},{"name":"穿衣指数","value":"炎热","detail":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"},{"name":"感冒指数","value":"少发","detail":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},{"name":"晾晒指数","value":"极适宜","detail":"天气不错，极适宜晾晒。抓紧时机把久未见阳光的衣物搬出来晒晒太阳吧！"},{"name":"旅游指数","value":"一般","detail":"天气较好，同时又有微风伴您一路同行，但是比较热，外出旅游请注意防晒，并注意防暑降温。"},{"name":"紫外线强度","value":"很强","detail":"紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。"},{"name":"洗车指数","value":"较适宜","detail":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},{"name":"运动指数","value":"较适宜","detail":"天气较好，户外运动请注意防晒。推荐您进行室内运动。"},{"name":"约会指数","value":"不适宜","detail":"风卷起热浪袭来，外出约会可能会因此败兴而归，最好在凉爽的室内约会。"},{"name":"雨伞指数","value":"不带伞","detail":"天气较好，您在出门的时候无须带雨伞。"}]}}
     * json 格式化后的样式请见：/app/json.txt
     */

    private RespBean resp;

    public RespBean getResp() {
        return resp;
    }

    public void setResp(RespBean resp) {
        this.resp = resp;
    }

    public static class RespBean {
        /**
         * city : 济南
         * updatetime : 17:09
         * wendu : 34
         * fengli : 3级
         * shidu : 49%
         * fengxiang : 东风
         * sunrise_1 : 05:19
         * sunset_1 : 19:15
         * sunrise_2 :
         * sunset_2 :
         * environment : {"aqi":95,"pm25":66,"suggest":"极少数敏感人群应减少户外活动","quality":"良","MajorPollutants":"颗粒物(PM10)","o3":164,"co":1,"pm10":138,"so2":18,"no2":35,"time":"12:00:00"}
         * yesterday : {"date_1":"3日星期四","high_1":"高温 31℃","low_1":"低温 25℃","day_1":{"type_1":"多云","fx_1":"南风","fl_1":"微风"},"night_1":{"type_1":"多云","fx_1":"南风","fl_1":"微风"}}
         * forecast : {"weather":[{"date":"4日星期五","high":"高温 35℃","low":"低温 25℃","day":{"type":"晴","fengxiang":"南风","fengli":"微风级"},"night":{"type":"晴","fengxiang":"南风","fengli":"微风级"}},{"date":"5日星期六","high":"高温 35℃","low":"低温 26℃","day":{"type":"晴","fengxiang":"东北风","fengli":"微风级"},"night":{"type":"晴","fengxiang":"东南风","fengli":"微风级"}},{"date":"6日星期天","high":"高温 34℃","low":"低温 24℃","day":{"type":"多云","fengxiang":"东北风","fengli":"微风级"},"night":{"type":"晴","fengxiang":"东北风","fengli":"微风级"}},{"date":"7日星期一","high":"高温 34℃","low":"低温 26℃","day":{"type":"多云","fengxiang":"东北风","fengli":"微风级"},"night":{"type":"多云","fengxiang":"北风","fengli":"微风级"}},{"date":"8日星期二","high":"高温 34℃","low":"低温 23℃","day":{"type":"多云","fengxiang":"南风","fengli":"微风级"},"night":{"type":"多云","fengxiang":"南风","fengli":"微风级"}}]}
         * zhishus : {"zhishu":[{"name":"晨练指数","value":"较适宜","detail":"早晨气象条件较适宜晨练，注意选择通风凉爽的地点。适量饮水以及时补充体内水分。"},{"name":"舒适度","value":"很不舒适","detail":"白天天气晴好，但烈日炎炎会使您会感到很热，很不舒适。"},{"name":"穿衣指数","value":"炎热","detail":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"},{"name":"感冒指数","value":"少发","detail":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},{"name":"晾晒指数","value":"极适宜","detail":"天气不错，极适宜晾晒。抓紧时机把久未见阳光的衣物搬出来晒晒太阳吧！"},{"name":"旅游指数","value":"一般","detail":"天气较好，同时又有微风伴您一路同行，但是比较热，外出旅游请注意防晒，并注意防暑降温。"},{"name":"紫外线强度","value":"很强","detail":"紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。"},{"name":"洗车指数","value":"较适宜","detail":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},{"name":"运动指数","value":"较适宜","detail":"天气较好，户外运动请注意防晒。推荐您进行室内运动。"},{"name":"约会指数","value":"不适宜","detail":"风卷起热浪袭来，外出约会可能会因此败兴而归，最好在凉爽的室内约会。"},{"name":"雨伞指数","value":"不带伞","detail":"天气较好，您在出门的时候无须带雨伞。"}]}
         */

        private String city;
        private String updatetime;
        private int wendu;
        private String fengli;
        private String shidu;
        private String fengxiang;
        private String sunrise_1;
        private String sunset_1;
        private String sunrise_2;
        private String sunset_2;
        private EnvironmentBean environment;
        private YesterdayBean yesterday;
        private ForecastBean forecast;
        private ZhishusBean zhishus;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public int getWendu() {
            return wendu;
        }

        public void setWendu(int wendu) {
            this.wendu = wendu;
        }

        public String getFengli() {
            return fengli;
        }

        public void setFengli(String fengli) {
            this.fengli = fengli;
        }

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public String getFengxiang() {
            return fengxiang;
        }

        public void setFengxiang(String fengxiang) {
            this.fengxiang = fengxiang;
        }

        public String getSunrise_1() {
            return sunrise_1;
        }

        public void setSunrise_1(String sunrise_1) {
            this.sunrise_1 = sunrise_1;
        }

        public String getSunset_1() {
            return sunset_1;
        }

        public void setSunset_1(String sunset_1) {
            this.sunset_1 = sunset_1;
        }

        public String getSunrise_2() {
            return sunrise_2;
        }

        public void setSunrise_2(String sunrise_2) {
            this.sunrise_2 = sunrise_2;
        }

        public String getSunset_2() {
            return sunset_2;
        }

        public void setSunset_2(String sunset_2) {
            this.sunset_2 = sunset_2;
        }

        public EnvironmentBean getEnvironment() {
            return environment;
        }

        public void setEnvironment(EnvironmentBean environment) {
            this.environment = environment;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public ForecastBean getForecast() {
            return forecast;
        }

        public void setForecast(ForecastBean forecast) {
            this.forecast = forecast;
        }

        public ZhishusBean getZhishus() {
            return zhishus;
        }

        public void setZhishus(ZhishusBean zhishus) {
            this.zhishus = zhishus;
        }

        public static class EnvironmentBean {
            /**
             * aqi : 95
             * pm25 : 66
             * suggest : 极少数敏感人群应减少户外活动
             * quality : 良
             * MajorPollutants : 颗粒物(PM10)
             * o3 : 164
             * co : 1
             * pm10 : 138
             * so2 : 18
             * no2 : 35
             * time : 12:00:00
             */

            private int aqi;
            private int pm25;
            private String suggest;
            private String quality;
            private String MajorPollutants;
            private int o3;
            private int co;
            private int pm10;
            private int so2;
            private int no2;
            private String time;

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public int getPm25() {
                return pm25;
            }

            public void setPm25(int pm25) {
                this.pm25 = pm25;
            }

            public String getSuggest() {
                return suggest;
            }

            public void setSuggest(String suggest) {
                this.suggest = suggest;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }

            public String getMajorPollutants() {
                return MajorPollutants;
            }

            public void setMajorPollutants(String MajorPollutants) {
                this.MajorPollutants = MajorPollutants;
            }

            public int getO3() {
                return o3;
            }

            public void setO3(int o3) {
                this.o3 = o3;
            }

            public int getCo() {
                return co;
            }

            public void setCo(int co) {
                this.co = co;
            }

            public int getPm10() {
                return pm10;
            }

            public void setPm10(int pm10) {
                this.pm10 = pm10;
            }

            public int getSo2() {
                return so2;
            }

            public void setSo2(int so2) {
                this.so2 = so2;
            }

            public int getNo2() {
                return no2;
            }

            public void setNo2(int no2) {
                this.no2 = no2;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public static class YesterdayBean {
            /**
             * date_1 : 3日星期四
             * high_1 : 高温 31℃
             * low_1 : 低温 25℃
             * day_1 : {"type_1":"多云","fx_1":"南风","fl_1":"微风"}
             * night_1 : {"type_1":"多云","fx_1":"南风","fl_1":"微风"}
             */

            private String date_1;
            private String high_1;
            private String low_1;
            private Day1Bean day_1;
            private Night1Bean night_1;

            public String getDate_1() {
                return date_1;
            }

            public void setDate_1(String date_1) {
                this.date_1 = date_1;
            }

            public String getHigh_1() {
                return high_1;
            }

            public void setHigh_1(String high_1) {
                this.high_1 = high_1;
            }

            public String getLow_1() {
                return low_1;
            }

            public void setLow_1(String low_1) {
                this.low_1 = low_1;
            }

            public Day1Bean getDay_1() {
                return day_1;
            }

            public void setDay_1(Day1Bean day_1) {
                this.day_1 = day_1;
            }

            public Night1Bean getNight_1() {
                return night_1;
            }

            public void setNight_1(Night1Bean night_1) {
                this.night_1 = night_1;
            }

            public static class Day1Bean {
                /**
                 * type_1 : 多云
                 * fx_1 : 南风
                 * fl_1 : 微风
                 */

                private String type_1;
                private String fx_1;
                private String fl_1;

                public String getType_1() {
                    return type_1;
                }

                public void setType_1(String type_1) {
                    this.type_1 = type_1;
                }

                public String getFx_1() {
                    return fx_1;
                }

                public void setFx_1(String fx_1) {
                    this.fx_1 = fx_1;
                }

                public String getFl_1() {
                    return fl_1;
                }

                public void setFl_1(String fl_1) {
                    this.fl_1 = fl_1;
                }
            }

            public static class Night1Bean {
                /**
                 * type_1 : 多云
                 * fx_1 : 南风
                 * fl_1 : 微风
                 */

                private String type_1;
                private String fx_1;
                private String fl_1;

                public String getType_1() {
                    return type_1;
                }

                public void setType_1(String type_1) {
                    this.type_1 = type_1;
                }

                public String getFx_1() {
                    return fx_1;
                }

                public void setFx_1(String fx_1) {
                    this.fx_1 = fx_1;
                }

                public String getFl_1() {
                    return fl_1;
                }

                public void setFl_1(String fl_1) {
                    this.fl_1 = fl_1;
                }
            }
        }

        public static class ForecastBean {
            private List<WeatherBean> weather;

            public List<WeatherBean> getWeather() {
                return weather;
            }

            public void setWeather(List<WeatherBean> weather) {
                this.weather = weather;
            }

            public static class WeatherBean {
                /**
                 * date : 4日星期五
                 * high : 高温 35℃
                 * low : 低温 25℃
                 * day : {"type":"晴","fengxiang":"南风","fengli":"微风级"}
                 * night : {"type":"晴","fengxiang":"南风","fengli":"微风级"}
                 */

                private String date;
                private String high;
                private String low;
                private DayBean day;
                private NightBean night;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getHigh() {
                    return high;
                }

                public void setHigh(String high) {
                    this.high = high;
                }

                public String getLow() {
                    return low;
                }

                public void setLow(String low) {
                    this.low = low;
                }

                public DayBean getDay() {
                    return day;
                }

                public void setDay(DayBean day) {
                    this.day = day;
                }

                public NightBean getNight() {
                    return night;
                }

                public void setNight(NightBean night) {
                    this.night = night;
                }

                public static class DayBean {
                    /**
                     * type : 晴
                     * fengxiang : 南风
                     * fengli : 微风级
                     */

                    private String type;
                    private String fengxiang;
                    private String fengli;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getFengxiang() {
                        return fengxiang;
                    }

                    public void setFengxiang(String fengxiang) {
                        this.fengxiang = fengxiang;
                    }

                    public String getFengli() {
                        return fengli;
                    }

                    public void setFengli(String fengli) {
                        this.fengli = fengli;
                    }
                }

                public static class NightBean {
                    /**
                     * type : 晴
                     * fengxiang : 南风
                     * fengli : 微风级
                     */

                    private String type;
                    private String fengxiang;
                    private String fengli;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getFengxiang() {
                        return fengxiang;
                    }

                    public void setFengxiang(String fengxiang) {
                        this.fengxiang = fengxiang;
                    }

                    public String getFengli() {
                        return fengli;
                    }

                    public void setFengli(String fengli) {
                        this.fengli = fengli;
                    }
                }
            }
        }

        public static class ZhishusBean {
            private List<ZhishuBean> zhishu;

            public List<ZhishuBean> getZhishu() {
                return zhishu;
            }

            public void setZhishu(List<ZhishuBean> zhishu) {
                this.zhishu = zhishu;
            }

            public static class ZhishuBean {
                /**
                 * name : 晨练指数
                 * value : 较适宜
                 * detail : 早晨气象条件较适宜晨练，注意选择通风凉爽的地点。适量饮水以及时补充体内水分。
                 */

                private String name;
                private String value;
                private String detail;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }
            }
        }
    }
}
