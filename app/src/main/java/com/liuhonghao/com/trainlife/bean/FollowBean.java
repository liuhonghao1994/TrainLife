package com.liuhonghao.com.trainlife.bean;

import java.util.List;

/**
 * Created by 刘红豪 on 2017/3/21.
 */

public class FollowBean {

    /**
     * code : 0
     * message : success
     * result : {"ad":{"body":[],"head":[{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/602234ae5f8b663e396e40dedf5b61d6cce409d7.jpg","link":"http://bangumi.bilibili.com/anime/5793","pub_time":"2017-03-20 23:00:00","title":"珈百璃的堕落"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/27eb75aaef49ff24fe3a4620be72aacfb16c7ee6.jpg","link":"http://bangumi.bilibili.com/anime/5794","pub_time":"2017-03-21 01:35:00","title":"飙速宅男 新世代"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/a5fd7006d3a30800bf2f251b8c9bbc290a545c2b.jpg","link":"http://bangumi.bilibili.com/anime/5792","pub_time":"2017-03-21 01:35:00","title":"鬼平"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/32c2d7f952cede66b2c7083924b1c6130fd26530.jpg","link":"http://bangumi.bilibili.com/anime/1299","pub_time":"2017-03-20 15:17:00","title":"彩云国物语"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/b3cad96f326d5690de22b8b0c908a4c060da091f.jpg","link":"http://bangumi.bilibili.com/anime/5945","pub_time":"2017-03-17 11:09:00","title":"七人魔法使 剧场版"}]},"previous":{"list":[{"cover":"http://i0.hdslb.com/bfs/bangumi/2673ac643b48eb5bda64c960a2ca850fbebb839d.jpg","favourites":"1672742","is_finish":1,"last_time":1482262210,"newest_ep_index":"11","pub_time":1475607600,"season_id":5550,"season_status":2,"title":"夏目友人帐 伍","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/b75c55d209d156c8631f5ceb21e5c52c834dbb60.jpg","favourites":"1330498","is_finish":0,"last_time":1483196409,"newest_ep_index":"1","pub_time":1483196400,"season_id":5747,"season_status":2,"title":"Fate/Grand Order \u2010First Order\u2010","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/b3633d2e5cafa0d048f4beef63618c92cfac4c4c.jpg","favourites":"785941","is_finish":1,"last_time":1482465609,"newest_ep_index":"12","pub_time":1475812800,"season_id":5534,"season_status":2,"title":"我太受欢迎了该怎么办","watching_count":0}],"season":4,"year":2016},"serializing":[{"cover":"http://i0.hdslb.com/bfs/bangumi/a161fc71b37116889eced3ad79733d07d47acc65.jpg","favourites":"36892","is_finish":0,"is_started":1,"last_time":1490090102,"newest_ep_index":"50","pub_time":1459785600,"season_id":3532,"season_status":2,"title":"美妙天堂  第三季","watching_count":201},{"cover":"http://i0.hdslb.com/bfs/bangumi/9925ece99e3458760fc074e8564f74a1d6f46e1d.jpg","favourites":"63865","is_finish":0,"is_started":1,"last_time":1490049902,"newest_ep_index":"25","pub_time":1474905600,"season_id":5504,"season_status":2,"title":"喵阿楞","watching_count":57},{"cover":"http://i0.hdslb.com/bfs/bangumi/afcd8b966344aa3e085b19a955c5e721020d6ce1.jpg","favourites":"94680","is_finish":0,"is_started":1,"last_time":1490031300,"newest_ep_index":"11","pub_time":1483983300,"season_id":5794,"season_status":2,"title":"飙速宅男 新世代","watching_count":1065},{"cover":"http://i0.hdslb.com/bfs/bangumi/7d2076e7cdcf3c3eaffad57ed6c9d987f2dbdeb8.jpg","favourites":"99135","is_finish":0,"is_started":1,"last_time":1490031300,"newest_ep_index":"11","pub_time":1483983300,"season_id":5792,"season_status":2,"title":"鬼平","watching_count":821},{"cover":"http://i0.hdslb.com/bfs/bangumi/3501378364ff84cbb42d2ee946334cd3b2dec453.jpg","favourites":"457596","is_finish":0,"is_started":1,"last_time":1490029500,"newest_ep_index":"23","pub_time":1475514300,"season_id":5542,"season_status":2,"title":"TRICKSTER","watching_count":421},{"cover":"http://i0.hdslb.com/bfs/bangumi/bb457cf8618b3a4db2179bf2dbe5b70950ea15fc.jpg","favourites":"45536","is_finish":0,"is_started":1,"last_time":1490025602,"newest_ep_index":"11","pub_time":1483977600,"season_id":5791,"season_status":2,"title":"新撰组镇魂歌 二分之一","watching_count":37}]}
     */

    private int code;
    private String message;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * ad : {"body":[],"head":[{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/602234ae5f8b663e396e40dedf5b61d6cce409d7.jpg","link":"http://bangumi.bilibili.com/anime/5793","pub_time":"2017-03-20 23:00:00","title":"珈百璃的堕落"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/27eb75aaef49ff24fe3a4620be72aacfb16c7ee6.jpg","link":"http://bangumi.bilibili.com/anime/5794","pub_time":"2017-03-21 01:35:00","title":"飙速宅男 新世代"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/a5fd7006d3a30800bf2f251b8c9bbc290a545c2b.jpg","link":"http://bangumi.bilibili.com/anime/5792","pub_time":"2017-03-21 01:35:00","title":"鬼平"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/32c2d7f952cede66b2c7083924b1c6130fd26530.jpg","link":"http://bangumi.bilibili.com/anime/1299","pub_time":"2017-03-20 15:17:00","title":"彩云国物语"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/b3cad96f326d5690de22b8b0c908a4c060da091f.jpg","link":"http://bangumi.bilibili.com/anime/5945","pub_time":"2017-03-17 11:09:00","title":"七人魔法使 剧场版"}]}
         * previous : {"list":[{"cover":"http://i0.hdslb.com/bfs/bangumi/2673ac643b48eb5bda64c960a2ca850fbebb839d.jpg","favourites":"1672742","is_finish":1,"last_time":1482262210,"newest_ep_index":"11","pub_time":1475607600,"season_id":5550,"season_status":2,"title":"夏目友人帐 伍","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/b75c55d209d156c8631f5ceb21e5c52c834dbb60.jpg","favourites":"1330498","is_finish":0,"last_time":1483196409,"newest_ep_index":"1","pub_time":1483196400,"season_id":5747,"season_status":2,"title":"Fate/Grand Order \u2010First Order\u2010","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/b3633d2e5cafa0d048f4beef63618c92cfac4c4c.jpg","favourites":"785941","is_finish":1,"last_time":1482465609,"newest_ep_index":"12","pub_time":1475812800,"season_id":5534,"season_status":2,"title":"我太受欢迎了该怎么办","watching_count":0}],"season":4,"year":2016}
         * serializing : [{"cover":"http://i0.hdslb.com/bfs/bangumi/a161fc71b37116889eced3ad79733d07d47acc65.jpg","favourites":"36892","is_finish":0,"is_started":1,"last_time":1490090102,"newest_ep_index":"50","pub_time":1459785600,"season_id":3532,"season_status":2,"title":"美妙天堂  第三季","watching_count":201},{"cover":"http://i0.hdslb.com/bfs/bangumi/9925ece99e3458760fc074e8564f74a1d6f46e1d.jpg","favourites":"63865","is_finish":0,"is_started":1,"last_time":1490049902,"newest_ep_index":"25","pub_time":1474905600,"season_id":5504,"season_status":2,"title":"喵阿楞","watching_count":57},{"cover":"http://i0.hdslb.com/bfs/bangumi/afcd8b966344aa3e085b19a955c5e721020d6ce1.jpg","favourites":"94680","is_finish":0,"is_started":1,"last_time":1490031300,"newest_ep_index":"11","pub_time":1483983300,"season_id":5794,"season_status":2,"title":"飙速宅男 新世代","watching_count":1065},{"cover":"http://i0.hdslb.com/bfs/bangumi/7d2076e7cdcf3c3eaffad57ed6c9d987f2dbdeb8.jpg","favourites":"99135","is_finish":0,"is_started":1,"last_time":1490031300,"newest_ep_index":"11","pub_time":1483983300,"season_id":5792,"season_status":2,"title":"鬼平","watching_count":821},{"cover":"http://i0.hdslb.com/bfs/bangumi/3501378364ff84cbb42d2ee946334cd3b2dec453.jpg","favourites":"457596","is_finish":0,"is_started":1,"last_time":1490029500,"newest_ep_index":"23","pub_time":1475514300,"season_id":5542,"season_status":2,"title":"TRICKSTER","watching_count":421},{"cover":"http://i0.hdslb.com/bfs/bangumi/bb457cf8618b3a4db2179bf2dbe5b70950ea15fc.jpg","favourites":"45536","is_finish":0,"is_started":1,"last_time":1490025602,"newest_ep_index":"11","pub_time":1483977600,"season_id":5791,"season_status":2,"title":"新撰组镇魂歌 二分之一","watching_count":37}]
         */

        private AdBean ad;
        private PreviousBean previous;
        private List<SerializingBean> serializing;

        public AdBean getAd() {
            return ad;
        }

        public void setAd(AdBean ad) {
            this.ad = ad;
        }

        public PreviousBean getPrevious() {
            return previous;
        }

        public void setPrevious(PreviousBean previous) {
            this.previous = previous;
        }

        public List<SerializingBean> getSerializing() {
            return serializing;
        }

        public void setSerializing(List<SerializingBean> serializing) {
            this.serializing = serializing;
        }

        public static class AdBean {
            private List<?> body;
            private List<HeadBean> head;

            public List<?> getBody() {
                return body;
            }

            public void setBody(List<?> body) {
                this.body = body;
            }

            public List<HeadBean> getHead() {
                return head;
            }

            public void setHead(List<HeadBean> head) {
                this.head = head;
            }

            public static class HeadBean {
                /**
                 * id : 0
                 * img : http://i0.hdslb.com/bfs/bangumi/602234ae5f8b663e396e40dedf5b61d6cce409d7.jpg
                 * link : http://bangumi.bilibili.com/anime/5793
                 * pub_time : 2017-03-20 23:00:00
                 * title : 珈百璃的堕落
                 */

                private int id;
                private String img;
                private String link;
                private String pub_time;
                private String title;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getPub_time() {
                    return pub_time;
                }

                public void setPub_time(String pub_time) {
                    this.pub_time = pub_time;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class PreviousBean {
            /**
             * list : [{"cover":"http://i0.hdslb.com/bfs/bangumi/2673ac643b48eb5bda64c960a2ca850fbebb839d.jpg","favourites":"1672742","is_finish":1,"last_time":1482262210,"newest_ep_index":"11","pub_time":1475607600,"season_id":5550,"season_status":2,"title":"夏目友人帐 伍","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/b75c55d209d156c8631f5ceb21e5c52c834dbb60.jpg","favourites":"1330498","is_finish":0,"last_time":1483196409,"newest_ep_index":"1","pub_time":1483196400,"season_id":5747,"season_status":2,"title":"Fate/Grand Order \u2010First Order\u2010","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/b3633d2e5cafa0d048f4beef63618c92cfac4c4c.jpg","favourites":"785941","is_finish":1,"last_time":1482465609,"newest_ep_index":"12","pub_time":1475812800,"season_id":5534,"season_status":2,"title":"我太受欢迎了该怎么办","watching_count":0}]
             * season : 4
             * year : 2016
             */

            private int season;
            private int year;
            private List<ListBean> list;

            public int getSeason() {
                return season;
            }

            public void setSeason(int season) {
                this.season = season;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * cover : http://i0.hdslb.com/bfs/bangumi/2673ac643b48eb5bda64c960a2ca850fbebb839d.jpg
                 * favourites : 1672742
                 * is_finish : 1
                 * last_time : 1482262210
                 * newest_ep_index : 11
                 * pub_time : 1475607600
                 * season_id : 5550
                 * season_status : 2
                 * title : 夏目友人帐 伍
                 * watching_count : 0
                 */

                private String cover;
                private String favourites;
                private int is_finish;
                private int last_time;
                private String newest_ep_index;
                private int pub_time;
                private int season_id;
                private int season_status;
                private String title;
                private int watching_count;

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getFavourites() {
                    return favourites;
                }

                public void setFavourites(String favourites) {
                    this.favourites = favourites;
                }

                public int getIs_finish() {
                    return is_finish;
                }

                public void setIs_finish(int is_finish) {
                    this.is_finish = is_finish;
                }

                public int getLast_time() {
                    return last_time;
                }

                public void setLast_time(int last_time) {
                    this.last_time = last_time;
                }

                public String getNewest_ep_index() {
                    return newest_ep_index;
                }

                public void setNewest_ep_index(String newest_ep_index) {
                    this.newest_ep_index = newest_ep_index;
                }

                public int getPub_time() {
                    return pub_time;
                }

                public void setPub_time(int pub_time) {
                    this.pub_time = pub_time;
                }

                public int getSeason_id() {
                    return season_id;
                }

                public void setSeason_id(int season_id) {
                    this.season_id = season_id;
                }

                public int getSeason_status() {
                    return season_status;
                }

                public void setSeason_status(int season_status) {
                    this.season_status = season_status;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getWatching_count() {
                    return watching_count;
                }

                public void setWatching_count(int watching_count) {
                    this.watching_count = watching_count;
                }
            }
        }

        public static class SerializingBean {
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/a161fc71b37116889eced3ad79733d07d47acc65.jpg
             * favourites : 36892
             * is_finish : 0
             * is_started : 1
             * last_time : 1490090102
             * newest_ep_index : 50
             * pub_time : 1459785600
             * season_id : 3532
             * season_status : 2
             * title : 美妙天堂  第三季
             * watching_count : 201
             */

            private String cover;
            private String favourites;
            private int is_finish;
            private int is_started;
            private int last_time;
            private String newest_ep_index;
            private int pub_time;
            private int season_id;
            private int season_status;
            private String title;
            private int watching_count;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getFavourites() {
                return favourites;
            }

            public void setFavourites(String favourites) {
                this.favourites = favourites;
            }

            public int getIs_finish() {
                return is_finish;
            }

            public void setIs_finish(int is_finish) {
                this.is_finish = is_finish;
            }

            public int getIs_started() {
                return is_started;
            }

            public void setIs_started(int is_started) {
                this.is_started = is_started;
            }

            public int getLast_time() {
                return last_time;
            }

            public void setLast_time(int last_time) {
                this.last_time = last_time;
            }

            public String getNewest_ep_index() {
                return newest_ep_index;
            }

            public void setNewest_ep_index(String newest_ep_index) {
                this.newest_ep_index = newest_ep_index;
            }

            public int getPub_time() {
                return pub_time;
            }

            public void setPub_time(int pub_time) {
                this.pub_time = pub_time;
            }

            public int getSeason_id() {
                return season_id;
            }

            public void setSeason_id(int season_id) {
                this.season_id = season_id;
            }

            public int getSeason_status() {
                return season_status;
            }

            public void setSeason_status(int season_status) {
                this.season_status = season_status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getWatching_count() {
                return watching_count;
            }

            public void setWatching_count(int watching_count) {
                this.watching_count = watching_count;
            }
        }
    }
}
