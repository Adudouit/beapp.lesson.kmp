#Cache

## Using the actual/expect pattern

Since Cache and more specifically file managment is bound to native platform, we have to use the actual/expect mechanism.

#### 1. Create the storage expected class

Using a `write` and `read` method

#### 2. Create the `actual` android class

Implement the actual android storage class using the Android File System

> Read
>  
```
File(storageDir, key).inputStream().use { it.readBytes().decodeToString() }
```

.

> Write
> 
```
File(storageDir, key)
	.outputStream()
	.use { it.write(value.toByteArray(Charset.defaultCharset())) }
```

#### 3. Create the `actual` iOS class

Implement the actual iOS storage class using the iOS File System

## Some complications

#### 1. Init properly for each platform

Each platform has its spefific for initializing and/or retreiving the file system.

Find a way to properly initialize each one


