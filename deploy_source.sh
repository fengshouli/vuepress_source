
#git init
git add deploy.sh docs/* package.json deploy_source.sh .github node-1.0-SNAPSHOT-jar-with-dependencies.jar
git commit -m '将源码发送到git'

git push -f git@github.com:fengshouli/vuepress_source.git master

cd -