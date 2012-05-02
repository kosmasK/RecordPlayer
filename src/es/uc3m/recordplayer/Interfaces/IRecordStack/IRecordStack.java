package es.uc3m.recordplayer.Interfaces.IRecordStack;

import es.uc3m.eda.list.IStack;

public interface IRecordStack<Record> extends IStack<Record> {

	public void push(Record elem);

	public Record pop();

	public Record top();
}
