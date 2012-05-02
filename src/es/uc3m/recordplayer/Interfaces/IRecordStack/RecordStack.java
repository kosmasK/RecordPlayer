package es.uc3m.recordplayer.Interfaces.IRecordStack;

import es.uc3m.eda.list.singlelink.SStack;

public class RecordStack<Record> extends SStack<Record> implements IRecordStack<Record>  {

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void push(Record elem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Record pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Record top() {
		// TODO Auto-generated method stub
		return null;
	}

}
