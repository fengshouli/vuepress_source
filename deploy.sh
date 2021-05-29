# 确保脚本抛出遇到的错误
#set -e

# 生成静态文件
vuepress build docs

# 进入生成的文件夹
#cd docs/.vuepress/dist
cd dist

# 如果是发布到自定义域名
# echo 'www.example.com' > CNAME

git init
git add .
git commit -m '自动打包部署到git'

# 如果发布到 https://<USERNAME>.github.io
# git push -f git@github.com:<USERNAME>/<USERNAME>.github.io.git master

# 如果发布到 https://<USERNAME>.github.io/<REPO>
# git push -f git@github.com:<USERNAME>/<REPO>.git master:gh-pages
git push -f git@github.com:fengshouli/fengshouli.github.io.git master

cd -