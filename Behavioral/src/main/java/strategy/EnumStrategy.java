package strategy;

public enum EnumStrategy implements GetByStrategy {
    MAIL("mail"){
         public ByItem getBy(String value) {
            return ByCreator.getByMail(value);
        }
    },
    NAME("name"){
         public ByItem getBy(String value) {
            return ByCreator.getByName(value);
        }
    };
    private String key;
    EnumStrategy(String key){
        this.key = key;
    }
}
