package com.rodrigo7prado.sisGestEduc.utils;

import java.sql.Timestamp;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.util.CsvContext;

public class ParseTimestamp extends CellProcessorAdaptor {

	public ParseTimestamp() {
        super();
    }
 
    public ParseTimestamp(CellProcessor next) {
        super(next);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public Object execute(Object value, CsvContext context) {
        return Timestamp.valueOf((String) value);
    }
}
