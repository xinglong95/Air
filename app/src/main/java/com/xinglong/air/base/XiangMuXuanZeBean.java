package com.xinglong.air.base;

import java.util.List;

public class XiangMuXuanZeBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : UN2017040003
         * name : 贵阳
         * children : [{"id":"UN2017040005","name":"贵阳1号线","children":[{"id":"UN2017040006","name":"列车6","children":[{"id":"UN2017040007","name":"车厢1","children":[{"id":"AC2017090001","name":"空调机组1"},{"id":"AC2017090002","name":"空调机组2"}]},{"id":"UN2017090005","name":"车厢2","children":[{"id":"AC2017090003","name":"空调机组1"},{"id":"AC2017090004","name":"空调机组2"}]},{"id":"UN2017090006","name":"车厢3","children":[{"id":"AC2017090005","name":"空调机组1"},{"id":"AC2017090006","name":"空调机组2"}]},{"id":"UN2017090007","name":"车厢4","children":[{"id":"AC2017090008","name":"空调机组1"},{"id":"AC2017090009","name":"空调机组2"}]},{"id":"UN2017090008","name":"车厢5","children":[{"id":"AC2017090010","name":"空调机组1"},{"id":"AC2017090011","name":"空调机组2"}]},{"id":"UN2017090009","name":"车厢6","children":[{"id":"AC2017090012","name":"空调机组1"},{"id":"AC2017090013","name":"空调机组2"}]},{"id":"UN2017100001","name":"车厢7(测试)","children":[{"id":"AC2017100001","name":"空调机组1"},{"id":"AC2017100002","name":"空调机组2"}]}]},{"id":"UN2018040001","name":"列车1","children":[{"id":"UN2018040002","name":"车厢1","children":[{"id":"AC2018040003","name":"空调机组1"},{"id":"AC2018040004","name":"空调机组2"}]}]},{"id":"UN2018040003","name":"列车2","children":[{"id":"UN2018040004","name":"车厢1","children":[{"id":"AC2018040005","name":"空调机组1"},{"id":"AC2018040006","name":"空调机组2"}]}]},{"id":"UN2018040005","name":"列车3","children":[{"id":"UN2018040006","name":"车厢1","children":[{"id":"AC2018040007","name":"空调机组1"},{"id":"AC2018040008","name":"空调机组2"}]}]},{"id":"UN2018040007","name":"列车4","children":[{"id":"UN2018040008","name":"车厢1","children":[{"id":"AC2018040011","name":"空调机组1"},{"id":"AC2018040012","name":"空调机组2"}]}]},{"id":"UN2018040009","name":"列车5","children":[{"id":"UN2018040010","name":"车厢1","children":[{"id":"AC2018040009","name":"空调机组1"},{"id":"AC2018040010","name":"空调机组2"}]}]}]}]
         */

        private String id;
        private String name;
        private List<ChildrenBeanXXX> children;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ChildrenBeanXXX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanXXX> children) {
            this.children = children;
        }

        public static class ChildrenBeanXXX {
            /**
             * id : UN2017040005
             * name : 贵阳1号线
             * children : [{"id":"UN2017040006","name":"列车6","children":[{"id":"UN2017040007","name":"车厢1","children":[{"id":"AC2017090001","name":"空调机组1"},{"id":"AC2017090002","name":"空调机组2"}]},{"id":"UN2017090005","name":"车厢2","children":[{"id":"AC2017090003","name":"空调机组1"},{"id":"AC2017090004","name":"空调机组2"}]},{"id":"UN2017090006","name":"车厢3","children":[{"id":"AC2017090005","name":"空调机组1"},{"id":"AC2017090006","name":"空调机组2"}]},{"id":"UN2017090007","name":"车厢4","children":[{"id":"AC2017090008","name":"空调机组1"},{"id":"AC2017090009","name":"空调机组2"}]},{"id":"UN2017090008","name":"车厢5","children":[{"id":"AC2017090010","name":"空调机组1"},{"id":"AC2017090011","name":"空调机组2"}]},{"id":"UN2017090009","name":"车厢6","children":[{"id":"AC2017090012","name":"空调机组1"},{"id":"AC2017090013","name":"空调机组2"}]},{"id":"UN2017100001","name":"车厢7(测试)","children":[{"id":"AC2017100001","name":"空调机组1"},{"id":"AC2017100002","name":"空调机组2"}]}]},{"id":"UN2018040001","name":"列车1","children":[{"id":"UN2018040002","name":"车厢1","children":[{"id":"AC2018040003","name":"空调机组1"},{"id":"AC2018040004","name":"空调机组2"}]}]},{"id":"UN2018040003","name":"列车2","children":[{"id":"UN2018040004","name":"车厢1","children":[{"id":"AC2018040005","name":"空调机组1"},{"id":"AC2018040006","name":"空调机组2"}]}]},{"id":"UN2018040005","name":"列车3","children":[{"id":"UN2018040006","name":"车厢1","children":[{"id":"AC2018040007","name":"空调机组1"},{"id":"AC2018040008","name":"空调机组2"}]}]},{"id":"UN2018040007","name":"列车4","children":[{"id":"UN2018040008","name":"车厢1","children":[{"id":"AC2018040011","name":"空调机组1"},{"id":"AC2018040012","name":"空调机组2"}]}]},{"id":"UN2018040009","name":"列车5","children":[{"id":"UN2018040010","name":"车厢1","children":[{"id":"AC2018040009","name":"空调机组1"},{"id":"AC2018040010","name":"空调机组2"}]}]}]
             */

            private String id;
            private String name;
            private List<ChildrenBeanXX> children;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ChildrenBeanXX> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBeanXX> children) {
                this.children = children;
            }

            public static class ChildrenBeanXX {
                /**
                 * id : UN2017040006
                 * name : 列车6
                 * children : [{"id":"UN2017040007","name":"车厢1","children":[{"id":"AC2017090001","name":"空调机组1"},{"id":"AC2017090002","name":"空调机组2"}]},{"id":"UN2017090005","name":"车厢2","children":[{"id":"AC2017090003","name":"空调机组1"},{"id":"AC2017090004","name":"空调机组2"}]},{"id":"UN2017090006","name":"车厢3","children":[{"id":"AC2017090005","name":"空调机组1"},{"id":"AC2017090006","name":"空调机组2"}]},{"id":"UN2017090007","name":"车厢4","children":[{"id":"AC2017090008","name":"空调机组1"},{"id":"AC2017090009","name":"空调机组2"}]},{"id":"UN2017090008","name":"车厢5","children":[{"id":"AC2017090010","name":"空调机组1"},{"id":"AC2017090011","name":"空调机组2"}]},{"id":"UN2017090009","name":"车厢6","children":[{"id":"AC2017090012","name":"空调机组1"},{"id":"AC2017090013","name":"空调机组2"}]},{"id":"UN2017100001","name":"车厢7(测试)","children":[{"id":"AC2017100001","name":"空调机组1"},{"id":"AC2017100002","name":"空调机组2"}]}]
                 */

                private String id;
                private String name;
                private List<ChildrenBeanX> children;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<ChildrenBeanX> getChildren() {
                    return children;
                }

                public void setChildren(List<ChildrenBeanX> children) {
                    this.children = children;
                }

                public static class ChildrenBeanX {
                    /**
                     * id : UN2017040007
                     * name : 车厢1
                     * children : [{"id":"AC2017090001","name":"空调机组1"},{"id":"AC2017090002","name":"空调机组2"}]
                     */

                    private String id;
                    private String name;
                    private List<ChildrenBean> children;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public List<ChildrenBean> getChildren() {
                        return children;
                    }

                    public void setChildren(List<ChildrenBean> children) {
                        this.children = children;
                    }

                    public static class ChildrenBean {
                        /**
                         * id : AC2017090001
                         * name : 空调机组1
                         */

                        private String id;
                        private String name;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }
                    }
                }
            }
        }
    }
}
