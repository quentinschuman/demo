import tkinter as tk
from tkinter import messagebox

win = tk.Tk()
win.title("Login")
win.geometry("400x300+100+100")
win.resizable(0,0)

# 将俩个标签分别布置在第一行、第二行
tk.Label(win, text="账号：").grid(row=0)
tk.Label(win, text="密码：").grid(row=1)

# 创建输入框控件
e1 = tk.Entry(win)
# 以 * 的形式显示密码
e2 = tk.Entry(win,show='*')
e1.grid(row=0, column=1, padx=10, pady=5)
e2.grid(row=1, column=1, padx=10, pady=5)

# 编写一个简单的回调函数
def login():
    if e1.get() == "admin" and e2.get() == "123":
        messagebox.showinfo("login_demo", "登录成功！")
    # else:messagebox.showerror("login_demo", "登录失败！")

# 使用 grid()的函数来布局，并控制按钮的显示位置
tk.Button(win, text="登录", width=10, command=login).grid(row=3, column=0, sticky="w", padx=10, pady=5)
tk.Button(win, text="退出", width=10, command=win.quit).grid(row=3, column=1, sticky="e", padx=10, pady=5)
win.mainloop()

if __name__ == '__main__':
    login()