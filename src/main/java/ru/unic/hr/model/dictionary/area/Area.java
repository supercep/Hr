package ru.unic.hr.model.dictionary.area;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;
import org.json.JSONObject;
import ru.unic.hr.model.dictionary.Model;
import ru.unic.hr.service.loader.AreasLoader;
import ru.unic.hr.service.parser.AreasParser;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by BritikovMI on 30.08.2019.
 */
public class Area {

    /**
     * id : 113
     * parent_id : null
     * name : Россия
     * areas : [{}]
     * */

    private String id;
    private Object parent_id;
    private String name;
    private List<AreasBeanX> areas;

    public static Area objectFromData(String str) {

        return new Gson().fromJson(str, Area.class);
    }

    public static Area objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(key), Area.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Area> arrayAreaFromData(String str) {

        Type listType = new TypeToken<ArrayList<Area>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Area> arrayAreaFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Area>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getParent_id() {
        return parent_id;
    }

    public void setParent_id(Object parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AreasBeanX> getAreas() {
        return areas;
    }

    public void setAreas(List<AreasBeanX> areas) {
        this.areas = areas;
    }

    public static class AreasBeanX {
        /**
         * id : 1620
         * parent_id : 113
         * name : Республика Марий Эл
         * areas : [{"id":"4228","parent_id":"1620","name":"Виловатово","areas":[]},{"id":"1621","parent_id":"1620","name":"Волжск","areas":[]},{"id":"1622","parent_id":"1620","name":"Звенигово","areas":[]},{"id":"4229","parent_id":"1620","name":"Знаменский","areas":[]},{"id":"61","parent_id":"1620","name":"Йошкар-Ола","areas":[]},{"id":"4230","parent_id":"1620","name":"Кельмаксола","areas":[]},{"id":"4231","parent_id":"1620","name":"Килемары","areas":[]},{"id":"1623","parent_id":"1620","name":"Козьмодемьянск","areas":[]},{"id":"4232","parent_id":"1620","name":"Красногорский (Республика Марий Эл)","areas":[]},{"id":"4233","parent_id":"1620","name":"Краснооктябрьский","areas":[]},{"id":"4234","parent_id":"1620","name":"Куженер","areas":[]},{"id":"4235","parent_id":"1620","name":"Мари-Турек","areas":[]},{"id":"4236","parent_id":"1620","name":"Медведево","areas":[]},{"id":"3667","parent_id":"1620","name":"Морки","areas":[]},{"id":"4237","parent_id":"1620","name":"Новый Торъял","areas":[]},{"id":"4238","parent_id":"1620","name":"Оршанка","areas":[]},{"id":"4239","parent_id":"1620","name":"Параньга","areas":[]},{"id":"4240","parent_id":"1620","name":"Приволжский (Республика Марий Эл)","areas":[]},{"id":"4241","parent_id":"1620","name":"Сернур","areas":[]},{"id":"4242","parent_id":"1620","name":"Советский (Республика Марий Эл)","areas":[]},{"id":"4243","parent_id":"1620","name":"Юрино","areas":[]}]
         */

        private String id;
        private String parent_id;
        private String name;
        private List<AreasBean> areas;

        public static AreasBeanX objectFromData(String str) {

            return new Gson().fromJson(str, AreasBeanX.class);
        }

        public static AreasBeanX objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), AreasBeanX.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<AreasBeanX> arrayAreasBeanXFromData(String str) {

            Type listType = new TypeToken<ArrayList<AreasBeanX>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<AreasBeanX> arrayAreasBeanXFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<AreasBeanX>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<AreasBean> getAreas() {
            return areas;
        }

        public void setAreas(List<AreasBean> areas) {
            this.areas = areas;
        }

        public static class AreasBean {
            /**
             * id : 4228
             * parent_id : 1620
             * name : Виловатово
             * areas : []
             */

            private String id;
            private String parent_id;
            private String name;
            private List<?> areas;

            public static AreasBean objectFromData(String str) {

                return new Gson().fromJson(str, AreasBean.class);
            }

            public static AreasBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), AreasBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<AreasBean> arrayAreasBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<AreasBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<AreasBean> arrayAreasBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<AreasBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<?> getAreas() {
                return areas;
            }

            public void setAreas(List<?> areas) {
                this.areas = areas;
            }
        }
    }

    public static List<Area> getModel() {
        String content = AreasLoader.areasLoad();

        AreasParser parser = new AreasParser();
        List<Area> areasModel = Arrays.asList(parser.parse(content));

        return areasModel;
    }
}
