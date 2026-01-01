public class TableDescription {
    String field;
    String type;
    String _null;
    String key;
    String _default;
    String extra;

    TableDescription(String field, String type, String _null, String key, String _default, String extra){
        this.field=field;
        this.type=type;
        this._null=_null;
        this.key=key;
        this._default=_default;
        this.extra=extra;
    }

    String getField(){return field;}
    String getType(){return type;}
    String get_null(){return _null;}
    String getKey(){return key;}
    String get_default(){return _default;}
    String getExtra(){return extra;}
}
