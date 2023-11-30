package study.lotto.model;

import java.util.ArrayList;
import java.util.List;

// 로또 티켓 정보를 표현하는 클래스.

public class LottoTicket {
	LottoRows rows;
	LottoColumns columns;
	
	LottoTicket(){
		rows = new LottoRows();;
		columns = new LottoColumns();		
	}
	
	public LottoRows getRows() {
		return rows;
	}
	public void setRows(LottoRows rows) {
		this.rows = rows;
	}
	public LottoColumns getColumns() {
		return columns;
	}
	public void setColumns(LottoColumns columns) {
		this.columns = columns;
	}

}

class LottoRows {
	private static final int TICKET_ROW = 6;
	public static int getTicketRow() {
		return TICKET_ROW;
	}


}

class LottoColumns {
	private static final int TICKET_COLUMN = 4; // Row하고 명명법 맞추는게 편해보여서 대문자로 함
	String[] referenceCharacter = { "A", "B", "C", "D", "E" };
	public static int getTICKET_COLUMN() {
		return TICKET_COLUMN;
	}
}
