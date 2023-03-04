import xlrd

from xlrd import xldate_as_tuple

import datetime

#导入需要读取的第一个Excel表格的路径

data1 = xlrd.open_workbook(r'testExcelWrite.xls')

table = data1.sheets()[0]

#创建一个空列表，存储Excel的数据

tables = []

#将excel表格内容导入到tables列表中

def import_excel(excel):

  for rown in range(excel.nrows):

   array = {'id':'','title':'','desc':'','check_flag':'','del_flag':'','create_time':'','update_time':''}

   array['id'] = table.cell_value(rown,0)
   array['title'] = table.cell_value(rown,1)
   array['desc'] = table.cell_value(rown,2)
   array['check_flag'] = table.cell_value(rown,3)
   array['del_flag'] = table.cell_value(rown,4)

   # array['create_time'] = table.cell_value(rown,5)
   # array['update_time'] = table.cell_value(rown,6)

   if (table.cell(rown,5).ctype == 3 or table.cell(rown,6).ctype == 3):

     create_date = xldate_as_tuple(table.cell(rown,5).value,0)

     array['create_time'] = datetime.datetime(*create_date).__str__()

     update_date = xldate_as_tuple(table.cell(rown,6).value,0)

     array['update_time'] = datetime.datetime(*update_date).__str__()

   tables.append(array)

if __name__ == '__main__':

  #将excel表格的内容导入到列表中

  import_excel(table)

  for i in tables:

    print(i)
