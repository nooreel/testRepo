package Paging;

public class EqPaging {
	
	
	private int totalCount=0;
	private int totalPage=0;
	private int pageNumber=0;
	private int pageSize=5;
	private int beginRow=0;
	private int endRow=0;
	private int pageCount=3;
	private int beginPage=0;
	private int endPage=0;
	private int offset=0;
	private int limit=0;
	private String url="";
	private String pagingHtml="";
	
	private String whatColumn="";
	private String keyword="";
	
	
	
	public EqPaging() {
	}

	public EqPaging(String textpageNumber,int totalCount,String url, String whatColumn, String keyword) {
		if(textpageNumber==null||textpageNumber=="") {
			textpageNumber="1";
		}
		this.pageNumber=Integer.parseInt(textpageNumber);
		this.offset=(pageNumber-1)*pageSize;
		
		this.totalCount=totalCount;
		this.limit=this.pageSize;
		
		
		
		this.totalPage=(int)Math.ceil((double)this.totalCount/this.limit);
		this.beginRow=(this.pageNumber-1)*this.pageSize+1;
		this.endRow=this.pageNumber*this.pageSize;
	
		if( this.endRow > this.totalCount ){
			this.endRow = this.totalCount  ;
		}
		
		this.beginPage = ( this.pageNumber - 1 ) / this.pageCount * this.pageCount + 1  ;
		this.endPage = this.beginPage + this.pageCount - 1 ;
		if( this.endPage > this.totalPage ){
			this.endPage = this.totalPage ;
		}
		
		
		this.url = url ; //  /ex/list.ab
		this.whatColumn = whatColumn ;
		this.keyword = keyword ;
		
		this.pagingHtml = getPagingHtml(url) ;
		
		
		
		System.out.println("totalCount"+this.totalCount);
		System.out.println("totalPage"+this.totalPage);
		System.out.println("offset"+this.offset);
		System.out.println("limit"+this.limit);
		System.out.println("beginrow"+this.beginRow);
		System.out.println("endrow"+this.endRow);
		
	}
	

	private String getPagingHtml( String url ){ //�������� ���ڿ��� �����.
		
		System.out.println("����¡������ ��Į��:"+this.whatColumn);
		System.out.println("����¡������ keyword:"+this.keyword);
		
		String result = "" ;
		
		//added_param ���� : �˻� �����Ͽ� �߰��Ǵ� �Ķ���� ����Ʈ
		String added_param = "&whatColumn=" + this.whatColumn + "&keyword=" + this.keyword ; 
		/*/ex/list.ab&whatColumn=singer&keyword=%��%*/
		
		if (this.beginPage != 1) { //����, pageSize:�� ȭ�鿡 ���̴� ���ڵ� ��
			// ó�� ��Ϻ��⸦ �ϸ� pageNumber�� 1�� �ǰ� beginPage�� 1�� �ȴ�. 
			result += "&nbsp;<a href='" + url  
					+ "?pageNumber=" + ( 1 ) + "&pageSize=" + this.pageSize + "'>�� ó��</a>&nbsp;" ;
			result += "&nbsp;<a href='" + url 
					+ "?pageNumber=" + (this.beginPage - 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>����</a>&nbsp;" ;
		}
		
		//���
		for (int i = this.beginPage; i <= this.endPage ; i++) {
			if ( i == this.pageNumber ) {
				result += "&nbsp;<font color='red'>" + i + "</font>&nbsp;"	;
						
			} else {
				result += "&nbsp;<a href='" + url   
						+ "?pageNumber=" + i + "&pageSize=" + this.pageSize 
						+ added_param + "'>" + i + "</a>&nbsp;" ;
				
			}
		}
		
		if ( this.endPage != this.totalPage) { // ����
			// endPage:���� ���� �������� ��(���� ���� �������� 13�̶�� endPage�� 20), totalPage:��ü ��������
			
			result += "&nbsp;<a href='" + url  
					+ "?pageNumber=" + (this.endPage + 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>����</a>&nbsp;" ;
			
			result += "&nbsp;<a href='" + url  
					+ "?pageNumber=" + (this.totalPage ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>�� ��</a>&nbsp;" ;
		}		
		
		return result ;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBeginRow() {
		return beginRow;
	}

	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public String getwhatColumn() {
		return whatColumn;
	}

	public void setwhatColumn(String whatColumn) {
		this.whatColumn = whatColumn;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}	
	
	
	
	
	
}
