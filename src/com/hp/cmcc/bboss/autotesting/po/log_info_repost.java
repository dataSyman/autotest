package com.hp.cmcc.bboss.autotesting.po;

import java.util.Date;
import oracle.sql.CLOB;

public class log_info_repost
{
  private Long id;
  private String seq_no;
  private Date create_date;
  private CLOB xml_content;
  private String xml_type;
  private Integer error_no;
  private String log_content;
  private int status;
  private Date update_date;

  public int getStatus()
  {
    return this.status;
  }

  public void setStatus(int status)
  {
    this.status = status;
  }

  public Date getUpdate_date()
  {
    return this.update_date;
  }

  public void setUpdate_date(Date update_date)
  {
    this.update_date = update_date;
  }

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getSeq_no()
  {
    return this.seq_no;
  }

  public void setSeq_no(String seq_no)
  {
    this.seq_no = seq_no;
  }

  public Date getCreate_date()
  {
    return this.create_date;
  }

  public void setCreate_date(Date create_date)
  {
    this.create_date = create_date;
  }

  public CLOB getXml_content()
  {
    return this.xml_content;
  }

  public void setXml_content(CLOB xml_content)
  {
    this.xml_content = xml_content;
  }

  public String getXml_type()
  {
    return this.xml_type;
  }

  public void setXml_type(String xml_type)
  {
    this.xml_type = xml_type;
  }

  public Integer getError_no()
  {
    return this.error_no;
  }

  public void setError_no(Integer error_no)
  {
    this.error_no = error_no;
  }

  public String getLog_content()
  {
    return this.log_content;
  }

  public void setLog_content(String log_content)
  {
    this.log_content = log_content;
  }

  public log_info_repost()
  {
  }

  public log_info_repost(Long id)
  {
    this.id = id;
  }
}
