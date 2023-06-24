package raf.rs.rafnews_web_2023.repository.api;

public interface NewsRepositoryAPI {

    enum ColumnNames{

        ID(1,"id",Integer.class),
        TITLE(2,"name",String.class),
        CONTENT(3,"description",String.class),

        AUTHOR_ID(4, "author_id",Integer.class);


        public Class typeClass;
        public final int column_index;
        public  final String column_name;
        ColumnNames(int index, String name, Class typeClass) {
            this.column_index = index;
            this.column_name = name;
            this.typeClass = typeClass;
        }

        public static String buildColumnsInsertQuery(String ... without)
        {   StringBuilder stringBuilder = new StringBuilder("(");
            ColumnNames[] names = values();

            for(int i = 1; i < names.length - 1; i++) {
                stringBuilder.append(names[i]).append(", ");
            }
            stringBuilder.append(names[names.length - 1]).append(")");
            System.out.println(stringBuilder.toString());
            System.out.flush();
            return stringBuilder.toString();
        }
        public static String buildColumnsUpdateQuery() {
            StringBuilder stringBuilder = new StringBuilder();
            ColumnNames[] names = values();

            for (int i = 1; i < names.length - 1; i++) {
                stringBuilder.append(names[i]).append(" = ?, ");
            }
            stringBuilder.append(names[names.length - 1]).append(" = ?");
            System.out.println(stringBuilder);
            return stringBuilder.toString();

        }
    }

}