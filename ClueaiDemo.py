import clueai
from clueai.classify import Example
from PIL import Image
class ClueaiDemo:
    # def __init__(self):
    #     self.textConception()
    #     self.NER()
    #     self.textGen()

    def textConception(self):
        cl = clueai.Client("", check_api_key=False)
        response = cl.classify(
            model_name='clueai-base',
            task_name='产品分类',
            inputs=["强大图片处理器，展现自然美丽的你,,修复部分小错误，提升整体稳定性。", "求闲置买卖，精品购物，上畅易无忧闲置商城，安全可信，优质商品有保障"],
            labels=["美颜", "二手", "外卖", "办公", "求职"])
        print('prediction: {}'.format(response.classifications))

    def NER(self):
        # initialize the Clueai Client with an API Key
        cl = clueai.Client("", check_api_key=False)
        prompt = '''
        信息抽取：
        据新华社电广东省清远市清城区政府昨日对外发布信息称,日前被实名举报涉嫌勒索企业、说“分分钟可以搞垮一间厂”的清城区环保局局长陈柏,已被免去清城区区委委员
        问题：机构名，人名，职位
        答案：
        '''
        prediction = cl.generate(
            model_name='clueai-base',
            prompt=prompt)
        # 需要返回得分的话，指定return_likelihoods="GENERATION"

        # print the predicted text
        print('prediction: {}'.format(prediction.generations[0].text))

    def textGen(self):
        # initialize the Clueai Client with an API Key
        cl = clueai.Client("", check_api_key=False)
        prompt = '''
        摘要：
        本文总结了十个可穿戴产品的设计原则，而这些原则，同样也是笔者认为是这个行业最吸引人的地方：1.为人们解决重复性问题；2.从人开始，而不是从机器开始；3.要引起注意，但不要刻意；4.提升用户能力，而不是取代人
        答案：
        '''
        # generate a prediction for a prompt

        generate_config = {
            "do_sample": True,
            "top_p": 0.8,
            "max_length": 128,
            "min_length": 10,
            "length_penalty": 1.0,
            "num_beams": 1
        }
        # 如果需要自由调整参数自由采样生成，添加额外参数信息设置方式：generate_config=generate_config
        prediction = cl.generate(
            model_name='clueai-base',
            prompt=prompt)
        # 需要返回得分的话，指定return_likelihoods="GENERATION"

        # print the predicted text
        print('prediction: {}'.format(prediction.generations[0].text))

    def textGenImg(self):
        cl = clueai.Client("", check_api_key=False)
        response = cl.text2image(
            model_name='clueai-base',
            prompt="秋日的晚霞",
            style="毕加索",
            out_file_path="test.png")

        im = Image.open('test.png')
        im.show()

    def apiUsageCount(self):
        # initialize the Clueai Client with an API Key
        # 微调用户finetune_user=True
        cl = clueai.Client('')
        print(cl.check_usage(finetune_user=False))

if __name__ == '__main__':
    demo = ClueaiDemo()
    demo.textConception()
    print("=========================================================")
    demo.NER()
    print("=========================================================")
    demo.textGen()
    print("=========================================================")
    demo.textGenImg()
    print("=========================================================")
    demo.apiUsageCount()