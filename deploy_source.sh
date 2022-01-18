
#git init
echo "开始.."
git add .
echo "添加所有文件,准备提交"
git commit -am '将源码发送到git'
echo "提交成功,准备push."
sleep 1s
git push -f git@github.com:fengshouli/vuepress_source.git master
# git push origin master
echo "完成"
