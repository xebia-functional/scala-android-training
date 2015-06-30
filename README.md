#Scala on Android: Training

This repository is aimed at developers who want to know how to work in Android using the Scala language. We have created different commits where you can learn step by step. The commits are:

1. **Preparing the environment**: In this commit you can check how to prepare your project and SBT configuration. You can learn more about that in these posts: [Preparing the environment](http://www.47deg.com/blog/scala-on-android-preparing-the-environment) and [Setting SBT Configuration](http://www.47deg.com/blog/scala-on-android-setting-sbt-configuration)
2. **DI: APIService and UserService**: We are using for this example the *Cake Pattern* as way to provide compile time dependency injection.
3. **Preparing UI**: Here is were we add the activity, layouts, adapter and everything we need for our UI
4. **Services & UI Integration**: We connect our services to UI
5. **Tests**: Tests for our services

About Example
====

The app shows different users listed showing their name and age. We preload the list with several default users and we use the API at random.org to create random users from Internet and as way to demonstrate async http resource access

Compile
======

You can compile this project and contribute improvements. To compile the project:

* Download [SBT](http://www.scala-sbt.org/) and install it
* Configure the [Android SDK](https://developer.android.com/sdk/index.html) on your computer. Remember that you should have installed `Android SDK Tools`, `Android SDK Build-tools`, `Android SDK Platform-tools`, `Android 5.1.1 (API 22)`, `Google Repository`, `Android Support Repository` and `Android Support Library`
* Set the `ANDROID_HOME` env variable to your SDK directory
* Clone this GitHub project to your computer
* From the project root directory run:

```
$ sbt
```

* Connect your phone and execute:

```
> run
```

You can use your favorite IDE. At 47 Degrees we use IntelliJ with the Scala plugin. If you want to run this project from IntelliJ you only need to import the project.

Follow each step
====

We have included [sbt-groll plugin](https://github.com/sbt/sbt-groll) so you can move around the Git commit history and see the progress from configuration to finally run it.

From the `sbt` console you can use:

```
> groll next
```

The will take you to next commit and step. Use `groll prev` if you want to go back. [More options here](https://github.com/sbt/sbt-groll#argumentsoptions)

License
======

Copyright (C) 2015 47 Degrees, LLC http://47deg.com hello@47deg.com

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.