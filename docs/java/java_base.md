# java基础

## 一.集合常用操作

### 1.List集合类型快速转换.

```
 public List<ProjectBasicRemoteDto> toProjectBasicDtos(List<ProjectBasicDto> projectBasicDtos){
        if(PMListUtil.isEmpty(projectBasicDtos)){
            return Collections.emptyList();
        }
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, ProjectBasicRemoteDto.class);
        List dtoList = objectMapper.convertValue(projectBasicDtos, listType);

        return dtoList;
    }
```

### 2.List如何正确返回

# java关键字

## 11
## 22

### 333