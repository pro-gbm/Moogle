/** @jsxImportSource @emotion/react */
import { css } from "@emotion/react";

import { CONST } from "../../constants";

const footer = css({
  height: CONST.FOOTERHEIGHT,
  width: "100%",
  color: "#FFF",
  display: "flex",
  alignItems: "center",
});

function SurveyFooter() {
  return <div css={footer}>여기는 푸터고 pro-gbm 로고가 들어갈거야</div>;
}

export default SurveyFooter;
