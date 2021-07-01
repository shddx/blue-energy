<template>
  <table class="table table-responsive-sm">
    <thead>
    <tr>
      <th>Номер</th>
      <th>тип</th>
      <th>Клиент</th>
      <th>Сума</th>
      <th>Подписан</th>
      <th>Истекает</th>
      <th>Изменен</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>Samppa Nori</td>
      <td>2012/01/01</td>
      <td>Member</td>
      <td><span class="badge badge-success">Active</span></td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import http from 'axios'

export default {
  name: "Contracts",
}
</script>

<style scoped>

</style>
