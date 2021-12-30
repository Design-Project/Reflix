<template>
  <div>
    <b-row>
      <b-list-group-item
        v-for="reply in replyData"
        v-bind:key="reply.replyId"
        class="d-flex justify-content-between align-items-center"
      >
        {{ reply.contents }}
        <div style="color: #ff0000; background-color: #ffffff">
          {{ reply.accountName }}
          <div style="color: black; background-color: Azure">
            {{ moment(reply.createdAt).format("YY-MM-DD HH:mm:ss") }}
          </div>
        </div>
      </b-list-group-item>
    </b-row>
  </div>
</template>

<script>
export default {
  name: "Reply",
  props: ["replyValue"],
  created() {
    this.replyData = this.replyValue
  },
  data() {
    return {
      replyData: null
    }
  }
}
</script>

<style></style>
