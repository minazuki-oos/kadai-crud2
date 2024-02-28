# 概要
このアプリケーションは、Spring BootフレームワークとMyBatisを使用して構築されたシンプルな魚のデータベースアプリケーションです。以下は、アプリケーションの概要と起動手順です。

アプリケーションの概要

Fishクラス

Fish クラスは、魚のデータを表すモデルクラスです。id、name、colorの属性を持っています。
コンストラクタやGetter、Setterなどが含まれています。
FishMapperインターフェース

FishMapper インターフェースは、MyBatisを使用してデータベースとのやり取りを行うためのメソッドを提供します。
データベースの操作に対応するSQLクエリが含まれています。
FishServiceクラス

FishService クラスは、ビジネスロジックを提供するサービスクラスです。
データベースへの操作を担当し、RESTAPIのエンドポイントで使用されるメソッドを提供します。
FishControllerクラス

FishController クラスは、APIエンドポイントを提供するためのSpring MVCコントローラです。
エンドポイント /fish_database を通じて魚のデータベースにアクセスできます。
FishApplicationクラス

FishApplication クラスは、Spring Bootアプリケーションのエントリーポイントで、main メソッドを含みます。
起動手順:

MySQLデータベースの起動

Docker Composeを使用してMySQLデータベースを起動します。
bash
Copy code
docker-compose up -d
Spring Bootアプリケーションの起動:

Spring Bootアプリケーションをビルドし、実行します。
bash
Copy code
./mvnw clean install
java -jar target/demo-0.0.1-SNAPSHOT.jar
または、IDEを使用してSpring Bootアプリケーションを実行できます。

#  APIの使用:

アプリケーションが正常に起動したら、以下のAPIエンドポイントを使用してデータの作成、取得、

POST

curl --location 'http://localhost:8080/fish_database' \
--header 'Content-Type: application/json' \
--data '{
"name": "tuna"
}
'

Get


curl --location --request GET 'http://localhost:8080/fish_database' \
--header 'Content-Type: application/json' \
--data '{
"name": "tuna"
}
'
# データ形式
JSON

