package Cars;
import javax.swing.*;
import java.util.*;

import javax.swing.AbstractListModel;

public class ListModel<E> extends AbstractListModel<E> {
	protected List<E> list;

	public ListModel(List<E> list) {
		this.list = list;
	}

	public void addElement(E element) {
		list.add(element);
		int index = list.size();
		fireContentsChanged(element, index, index);
	}

	public void fireDataChanged() {
		int index = list.size();
		fireContentsChanged(list.get(index - 1), index, index);
	}

	public int getSize() {
		return list.size();
	}

	public E getElementAt(int index) {
		return list.get(index);
	}
}