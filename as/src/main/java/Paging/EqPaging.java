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
	

	private String getPagingHtml( String url ){ //페이지를 문자열로 만든다.
		
		System.out.println("페이징에서의 왓칼럼:"+this.whatColumn);
		System.out.println("페이징에서의 keyword:"+this.keyword);
		
		String result = "" ;
		
		//added_param 변수 : 검색 관련하여 추가되는 파라미터 리스트
		String added_param = "&whatColumn=" + this.whatColumn + "&keyword=" + this.keyword ; 
		/*/ex/list.ab&whatColumn=singer&keyword=%아%*/
		
		if (this.beginPage != 1) { //앞쪽, pageSize:한 화면에 보이는 레코드 수
			// 처음 목록보기를 하면 pageNumber는 1이 되고 beginPage도 1이 된다. 
			result += "&nbsp;<a href='" + url  
					+ "?pageNumber=" + ( 1 ) + "&pageSize=" + this.pageSize + "'>맨 처음</a>&nbsp;" ;
			result += "&nbsp;<a href='" + url 
					+ "?pageNumber=" + (this.beginPage - 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>이전</a>&nbsp;" ;
		}
		
		//가운데
		for (int i = this.beginPage; i <= this.endPage ; i++) {
			if ( i == this.pageNumber ) {
				result += "&nbsp;<font color='red'>" + i + "</font>&nbsp;"	;
						
			} else {
				result += "&nbsp;<a href='" + url   
						+ "?pageNumber=" + i + "&pageSize=" + this.pageSize 
						+ added_param + "'>" + i + "</a>&nbsp;" ;
				
			}
		}
		
		if ( this.endPage != this.totalPage) { // 뒤쪽
			// endPage:지금 보는 페이지의 끝(지금 보는 페이지가 13이라면 endPage는 20), totalPage:전체 페이지수
			
			result += "&nbsp;<a href='" + url  
					+ "?pageNumber=" + (this.endPage + 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>다음</a>&nbsp;" ;
			
			result += "&nbsp;<a href='" + url  
					+ "?pageNumber=" + (this.totalPage ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>맨 끝</a>&nbsp;" ;
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
