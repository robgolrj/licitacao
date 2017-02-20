package com.prova.commom;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class JsonDateDeserializer extends JsonDeserializer<Date> {

    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private static final DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        try {
            return (Date)dateFormat.parse(node.asText());
        } catch (ParseException e) {
            try {
                return (Date)dateFormat2.parse(node.asText());
            } catch (ParseException e1) {
                throw new IOException(e);
            }

        }
    }
}