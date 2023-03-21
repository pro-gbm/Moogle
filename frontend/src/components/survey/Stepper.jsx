/** @jsxImportSource @emotion/react */
import { css } from "@emotion/react";

const stepper = css({
  backgroundColor: "#f89d13",
  marginLeft: "5px",
  marginRight: "5px",
  width: "10vw",
  minWidth: "50px",
  maxWidth: "100px",
  height: "5px",
});
function Stepper() {
  return <div css={stepper}></div>;
}

export default Stepper;
