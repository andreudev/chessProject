package com.chess.enums;


import com.chess.myexceptions.DataTypeError;


public enum DataType {
    CHARACTER("c","Caracter"), NUMBER("n","Numerico");

    private final String type;
    private final String description;

    DataType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getDataType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    private static DataType fromString(String type) throws DataTypeError {
            for (DataType dataType : DataType.values()) {
                if (dataType.getDataType().equals(type)) {
                    return dataType;
                }
            }
            throw new DataTypeError("Invalid data type");
    }

    public static DataType checkFromString(String type) {
        try {
            return fromString(type);
        } catch (DataTypeError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(DataType.fromString("c"));
            System.out.println(DataType.fromString("n"));
            System.out.println(DataType.fromString("a"));
        } catch (DataTypeError e) {
            System.out.println(e.getMessage());
        }
    }
}
