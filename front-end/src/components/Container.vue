<template>
  <div>
    <Post1/>
    <Post2/>
    <Post3/>
  </div>
</template>

<script>
import Post1 from './Post1.vue'
import Post2 from './Post2.vue'
import Post3 from './Post3.vue'
export default {
    components : {
    Post1,
    Post2,
    Post3,
  }
}
</script>