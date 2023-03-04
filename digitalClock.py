from tkinter import *
from time import strftime

root = Tk()
root.geometry("500x300+300+300")
root.iconbitmap("https://www.baidu.com/img/flexible/logo/pc/peak-result.png")
root.title("digital_clock")

# 设置文本标签
lb = Label(root, font=("微软雅黑", 50, "bold"), bg='#87CEEB', fg="#B452CD")
lb.pack(anchor="center", fill="both", expand=1)

# 定义一个mode标志
mode = 'date'
# 定义显示时间的函数
def showtime():
    if mode == "time":
        string = strftime("%H:%M:%S %p")
    else:
        string = strftime("%Y-%m-%d")
    lb.config(text = string)
    # 每隔 1秒钟执行time函数
    lb.after(1000, showtime)


# 定义鼠标处理事件，点击时间切换为日期样式显示
def mouseClick(event):
    global mode
    if mode == "time":
        # 点击切换mode样式为日期样式
        mode = "date"
    else:
        mode = "time"

lb.bind("<Button>", mouseClick)

if __name__ == '__main__':
    # 调用showtime()函数
    showtime()
    mouseClick("<Button>")
    # 显示窗口
    mainloop()