import React, { useState } from "react";
import { useParams } from "react-router-dom";
export default function User() {
  // Declare a new state variable, which we'll call "count"
  const [count, setCount] = useState(0);
  let params = useParams();
  return <h2>Invoice: {params.userId}</h2>;
}
