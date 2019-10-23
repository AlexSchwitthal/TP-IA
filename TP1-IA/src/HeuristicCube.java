
public class HeuristicCube extends Heuristic{
	public float value(Cube etat){
		float h = 0;
		float h3 = 0;
		char aFace = etat.upFace[1][0], bFace = etat.leftFace[0][1];
		if(aFace == etat.upFace[1][1]) {
			if(bFace == etat.leftFace[1][1]) {
				h += 0;
			}
			else {
				if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
					h += 1;
					if(h3 < 1)
						h3 = 1;
				}
				else {
					h += 2;
					if(h3 < 2)
						h3 = 2;
				}
			}
		}
		else {
			if(aFace == etat.leftFace[1][1]) {
				if(bFace == etat.upFace[1][1]) {
					h += 3;
					if(h3 < 3)
						h3 = 3;
				}
				else {
					if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
						h += 2;
						if(h3 < 2)
							h3 = 2;
					}
					else {
						h += 3;
						if(h3 < 3)
							h3 = 3;
					}
				}
			}
			else {
				if(aFace == etat.backFace[1][1]) {
					if(bFace == etat.leftFace[1][1]) {
						h += 1;
						if(h3 < 1)
							h3 = 1;
					}
					else {
						if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
							h += 2;
							if(h3 < 2)
								h3 = 2;
						}
						else {
							h += 3;
							if(h3 < 2)
								h3 = 2;
						}
					}
				}
				else {
					if(aFace == etat.frontFace[1][1]) {
						if(bFace == etat.leftFace[1][1]) {
							h += 1;
							if(h3 < 1)
								h3 = 1;
						}
						else {
							if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								h += 3;
								if(h3 < 3)
									h3 = 3;
							}
						}
					}
					else {
						if(aFace == etat.downFace[1][1]) {
							if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								//if(etat.leftFace[0][1] == etat.frontFace[1][1] || etat.leftFace[0][1] == etat.backFace[1][1]) {
									h += 3;
									if(h3 < 3)
										h3 = 3;
								//}
							}
						}
						else {
							//if(etat.upFace[1][0] == etat.rightFace[1][1]) {
								if(bFace == etat.upFace[1][1]) {
									h += 1;
									if(h3 < 1)
										h3 = 1;
								}
								else {
									if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
										h += 2;
										if(h3 < 2)
											h3 = 2;
									}
									else {
										h += 3;
										if(h3 < 3)
											h3 = 3;
									}
								}
							//}
						}
					}
				}
			}
		}
		
		aFace = etat.upFace[0][1];
		bFace = etat.backFace[0][1];
		if(aFace == etat.upFace[1][1]) {
			if(bFace == etat.backFace[1][1]) {
				h += 0;
			}
			else {
				if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
					h += 1;
					if(h3 < 1)
						h3 = 1;
				}
				else {
					h += 2;
					if(h3 < 2)
						h3 = 2;
				}
			}
		}
		else {
			if(aFace == etat.backFace[1][1]) {
				if(bFace == etat.upFace[1][1]) {
					h += 3;
					if(h3 < 3)
						h3 = 3;
				}
				else {
					if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
						h += 2;
						if(h3 < 2)
							h3 = 2;
					}
					else {
						h += 3;
						if(h3 < 3)
							h3 = 3;
					}
				}
			}
			else {
				if(aFace == etat.rightFace[1][1]) {
					if(bFace == etat.backFace[1][1]) {
						h += 1;
						if(h3 < 1)
							h3 = 1;
					}
					else {
						if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
							h += 2;
							if(h3 < 2)
								h3 = 2;
						}
						else {
							h += 3;
							if(h3 < 3)
								h3 = 3;
						}
					}
				}
				else {
					if(aFace == etat.leftFace[1][1]) {
						if(bFace == etat.backFace[1][1]) {
							h += 1;
							if(h3 < 1)
								h3 = 1;
						}
						else {
							if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								h += 3;
								if(h3 < 3)
									h3 = 3;
							}
						}
					}
					else {
						if(aFace == etat.downFace[1][1]) {
							if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								//if(etat.leftFace[0][1] == etat.frontFace[1][1] || etat.leftFace[0][1] == etat.backFace[1][1]) {
									h += 3;
									if(h3 < 3)
										h3 = 3;
								//}
							}
						}
						else {
							//if(etat.upFace[1][0] == etat.rightFace[1][1]) {
								if(bFace == etat.upFace[1][1]) {
									h += 1;
									if(h3 < 1)
										h3 = 1;
								}
								else {
									if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
										h += 2;
										if(h3 < 2)
											h3 = 2;
									}
									else {
										h += 3;
										if(h3 < 3)
											h3 = 3;
									}
								}
							//}
						}
					}
				}
			}
		}
		
		aFace = etat.upFace[1][2];
		bFace = etat.rightFace[0][1];
		if(aFace == etat.upFace[1][1]) {
			if(bFace == etat.rightFace[1][1]) {
				h += 0;
			}
			else {
				if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
					h += 1;
					if(h3 < 1)
						h3 = 1;
				}
				else {
					h += 2;
					if(h3 < 2)
						h3 = 2;
				}
			}
		}
		else {
			if(aFace == etat.rightFace[1][1]) {
				if(bFace == etat.upFace[1][1]) {
					h += 3;
					if(h3 < 3)
						h3 = 3;
				}
				else {
					if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
						h += 2;
						if(h3 < 2)
							h3 = 2;
					}
					else {
						h += 3;
						if(h3 < 3)
							h3 = 3;
					}
				}
			}
			else {
				if(aFace == etat.frontFace[1][1]) {
					if(bFace == etat.rightFace[1][1]) {
						h += 1;
						if(h3 < 1)
							h3 = 1;
					}
					else {
						if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
							h += 2;
							if(h3 < 2)
								h3 = 2;
						}
						else {
							h += 3;
							if(h3 < 3)
								h3 = 3;
						}
					}
				}
				else {
					if(aFace == etat.backFace[1][1]) {
						if(bFace == etat.rightFace[1][1]) {
							h += 1;
							if(h3 < 1)
								h3 = 1;
						}
						else {
							if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								h += 3;
								if(h3 < 3)
									h3 = 3;
							}
						}
					}
					else {
						if(aFace == etat.downFace[1][1]) {
							if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								//if(etat.leftFace[0][1] == etat.frontFace[1][1] || etat.leftFace[0][1] == etat.backFace[1][1]) {
									h += 3;
									if(h3 < 3)
										h3 = 3;
								//}
							}
						}
						else {
							//if(etat.upFace[1][0] == etat.rightFace[1][1]) {
								if(bFace == etat.upFace[1][1]) {
									h += 1;
									if(h3 < 1)
										h3 = 1;
								}
								else {
									if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
										h += 2;
										if(h3 < 2)
											h3 = 2;
									}
									else {
										h += 3;
										if(h3 < 3)
											h3 = 3;
									}
								}
							//}
						}
					}
				}
			}
		}
		////////
		aFace = etat.upFace[2][1];
		bFace = etat.frontFace[0][1];
		if(aFace == etat.upFace[1][1]) {
			if(bFace == etat.frontFace[1][1]) {
				h += 0;
			}
			else {
				if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
					h += 1;
					if(h3 < 1)
						h3 = 1;
				}
				else {
					h += 2;
					if(h3 < 2)
						h3 = 2;
				}
			}
		}
		else {
			if(aFace == etat.frontFace[1][1]) {
				if(bFace == etat.upFace[1][1]) {
					h += 3;
					if(h3 < 3)
						h3 = 3;
				}
				else {
					if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
						h += 2;
						if(h3 < 2)
							h3 = 2;
					}
					else {
						h += 3;
						if(h3 < 3)
							h3 = 3;
					}
				}
			}
			else {
				if(aFace == etat.leftFace[1][1]) {
					if(bFace == etat.frontFace[1][1]) {
						h += 1;
						if(h3 < 1)
							h3 = 1;
					}
					else {
						if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
							h += 2;
							if(h3 < 2)
								h3 = 2;
						}
						else {
							h += 3;
							if(h3 < 3)
								h3 = 3;
						}
					}
				}
				else {
					if(aFace == etat.rightFace[1][1]) {
						if(bFace == etat.frontFace[1][1]) {
							h += 1;
							if(h3 < 1)
								h3 = 1;
						}
						else {
							if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								h += 3;
								if(h3 < 3)
									h3 = 3;
							}
						}
					}
					else {
						if(aFace == etat.downFace[1][1]) {
							if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								//if(etat.leftFace[0][1] == etat.frontFace[1][1] || etat.leftFace[0][1] == etat.backFace[1][1]) {
									h += 3;
									if(h3 < 3)
										h3 = 3;
								//}
							}
						}
						else {
							//if(etat.upFace[1][0] == etat.rightFace[1][1]) {
								if(bFace == etat.upFace[1][1]) {
									h += 1;
									if(h3 < 1)
										h3 = 1;
								}
								else {
									if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
										h += 2;
										if(h3 < 2)
											h3 = 2;
									}
									else {
										h += 3;
										if(h3 < 3)
											h3 = 3;
									}
								}
							//}
						}
					}
				}
			}
		}
		//////
		aFace = etat.downFace[0][1];
		bFace = etat.frontFace[2][1];
		if(aFace == etat.downFace[1][1]) {
			if(bFace == etat.frontFace[1][1]) {
				h += 0;
			}
			else {
				if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
					h += 1;
					if(h3 < 1)
						h3 = 1;
				}
				else {
					h += 2;
					if(h3 < 2)
						h3 = 2;
				}
			}
		}
		else {
			if(aFace == etat.frontFace[1][1]) {
				if(bFace == etat.downFace[1][1]) {
					h += 3;
					if(h3 < 3)
						h3 = 3;
				}
				else {
					if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
						h += 2;
						if(h3 < 2)
							h3 = 2;
					}
					else {
						h += 3;
						if(h3 < 3)
							h3 = 3;
					}
				}
			}
			else {
				if(aFace == etat.rightFace[1][1]) {
					if(bFace == etat.frontFace[1][1]) {
						h += 1;
						if(h3 < 1)
							h3 = 1;
					}
					else {
						if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
							h += 2;
							if(h3 < 2)
								h3 = 2;
						}
						else {
							h += 3;
							if(h3 < 3)
								h3 = 3;
						}
					}
				}
				else {
					if(aFace == etat.leftFace[1][1]) {
						if(bFace == etat.frontFace[1][1]) {
							h += 1;
							if(h3 < 1)
								h3 = 1;
						}
						else {
							if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								h += 3;
								if(h3 < 3)
									h3 = 3;
							}
						}
					}
					else {
						if(aFace == etat.upFace[1][1]) {
							if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								//if(etat.leftFace[0][1] == etat.frontFace[1][1] || etat.leftFace[0][1] == etat.backFace[1][1]) {
									h += 3;
									if(h3 < 3)
										h3 = 3;
								//}
							}
						}
						else {
							//if(etat.upFace[1][0] == etat.rightFace[1][1]) {
								if(bFace == etat.downFace[1][1]) {
									h += 1;
									if(h3 < 1)
										h3 = 1;
								}
								else {
									if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
										h += 2;
										if(h3 < 2)
											h3 = 2;
									}
									else {
										h += 3;
										if(h3 < 3)
											h3 = 3;
									}
								}
							//}
						}
					}
				}
			}
		}
		
		aFace = etat.downFace[1][0];
		bFace = etat.leftFace[2][1];
		if(aFace == etat.downFace[1][1]) {
			if(bFace == etat.leftFace[1][1]) {
				h += 0;
			}
			else {
				if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
					h += 1;
					if(h3 < 1)
						h3 = 1;
				}
				else {
					h += 2;
					if(h3 < 2)
						h3 = 2;
				}
			}
		}
		else {
			if(aFace == etat.leftFace[1][1]) {
				if(bFace == etat.downFace[1][1]) {
					h += 3;
					if(h3 < 3)
						h3 = 3;
				}
				else {
					if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
						h += 2;
						if(h3 < 2)
							h3 = 2;
					}
					else {
						h += 3;
						if(h3 < 3)
							h3 = 3;
					}
				}
			}
			else {
				if(aFace == etat.frontFace[1][1]) {
					if(bFace == etat.leftFace[1][1]) {
						h += 1;
						if(h3 < 1)
							h3 = 1;
					}
					else {
						if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
							h += 2;
							if(h3 < 2)
								h3 = 2;
						}
						else {
							h += 3;
							if(h3 < 3)
								h3 = 3;
						}
					}
				}
				else {
					if(aFace == etat.backFace[1][1]) {
						if(bFace == etat.leftFace[1][1]) {
							h += 1;
							if(h3 < 1)
								h3 = 1;
						}
						else {
							if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								h += 3;
								if(h3 < 3)
									h3 = 3;
							}
						}
					}
					else {
						if(aFace == etat.upFace[1][1]) {
							if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								//if(etat.leftFace[0][1] == etat.frontFace[1][1] || etat.leftFace[0][1] == etat.backFace[1][1]) {
									h += 3;
									if(h3 < 3)
										h3 = 3;
								//}
							}
						}
						else {
							//if(etat.upFace[1][0] == etat.rightFace[1][1]) {
								if(bFace == etat.downFace[1][1]) {
									h += 1;
									if(h3 < 1)
										h3 = 1;
								}
								else {
									if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
										h += 2;
										if(h3 < 2)
											h3 = 2;
									}
									else {
										h += 3;
										if(h3 < 3)
											h3 = 3;
									}
								}
							//}
						}
					}
				}
			}
		}
		
		aFace = etat.downFace[2][1];
		bFace = etat.backFace[2][1];
		if(aFace == etat.downFace[1][1]) {
			if(bFace == etat.backFace[1][1]) {
				h += 0;
			}
			else {
				if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
					h += 1;
					if(h3 < 1)
						h3 = 1;
				}
				else {
					h += 2;
					if(h3 < 2)
						h3 = 2;
				}
			}
		}
		else {
			if(aFace == etat.backFace[1][1]) {
				if(bFace == etat.downFace[1][1]) {
					h += 3;
					if(h3 < 3)
						h3 = 3;
				}
				else {
					if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
						h += 2;
						if(h3 < 2)
							h3 = 2;
					}
					else {
						h += 3;
						if(h3 < 3)
							h3 = 3;
					}
				}
			}
			else {
				if(aFace == etat.leftFace[1][1]) {
					if(bFace == etat.backFace[1][1]) {
						h += 1;
						if(h3 < 1)
							h3 = 1;
					}
					else {
						if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
							h += 2;
							if(h3 < 2)
								h3 = 2;
						}
						else {
							h += 3;
							if(h3 < 3)
								h3 = 3;
						}
					}
				}
				else {
					if(aFace == etat.rightFace[1][1]) {
						if(bFace == etat.backFace[1][1]) {
							h += 1;
							if(h3 < 1)
								h3 = 1;
						}
						else {
							if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								h += 3;
								if(h3 < 3)
									h3 = 3;
							}
						}
					}
					else {
						if(aFace == etat.upFace[1][1]) {
							if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								//if(etat.leftFace[0][1] == etat.frontFace[1][1] || etat.leftFace[0][1] == etat.backFace[1][1]) {
									h += 3;
									if(h3 < 3)
										h3 = 3;
								//}
							}
						}
						else {
							//if(etat.upFace[1][0] == etat.rightFace[1][1]) {
								if(bFace == etat.downFace[1][1]) {
									h += 1;
									if(h3 < 1)
										h3 = 1;
								}
								else {
									if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
										h += 2;
										if(h3 < 2)
											h3 = 2;
									}
									else {
										h += 3;
										if(h3 < 3)
											h3 = 3;
									}
								}
							//}
						}
					}
				}
			}
		}
		
		aFace = etat.downFace[1][2];
		bFace = etat.rightFace[2][1];
		if(aFace == etat.downFace[1][1]) {
			if(bFace == etat.rightFace[1][1]) {
				h += 0;
			}
			else {
				if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
					h += 1;
					if(h3 < 1)
						h3 = 1;
				}
				else {
					h += 2;
					if(h3 < 2)
						h3 = 2;
				}
			}
		}
		else {
			if(aFace == etat.rightFace[1][1]) {
				if(bFace == etat.downFace[1][1]) {
					h += 3;
					if(h3 < 3)
						h3 = 3;
				}
				else {
					if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
						h += 2;
						if(h3 < 2)
							h3 = 2;
					}
					else {
						h += 3;
						if(h3 < 3)
							h3 = 3;
					}
				}
			}
			else {
				if(aFace == etat.backFace[1][1]) {
					if(bFace == etat.rightFace[1][1]) {
						h += 1;
						if(h3 < 1)
							h3 = 1;
					}
					else {
						if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
							h += 2;
							if(h3 < 2)
								h3 = 2;
						}
						else {
							h += 3;
							if(h3 < 3)
								h3 = 3;
						}
					}
				}
				else {
					if(aFace == etat.frontFace[1][1]) {
						if(bFace == etat.rightFace[1][1]) {
							h += 1;
							if(h3 < 1)
								h3 = 1;
						}
						else {
							if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								h += 3;
								if(h3 < 3)
									h3 = 3;
							}
						}
					}
					else {
						if(aFace == etat.upFace[1][1]) {
							if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								//if(etat.leftFace[0][1] == etat.frontFace[1][1] || etat.leftFace[0][1] == etat.backFace[1][1]) {
									h += 3;
									if(h3 < 3)
										h3 = 3;
								//}
							}
						}
						else {
							//if(etat.upFace[1][0] == etat.rightFace[1][1]) {
								if(bFace == etat.downFace[1][1]) {
									h += 1;
									if(h3 < 1)
										h3 = 1;
								}
								else {
									if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
										h += 2;
										if(h3 < 2)
											h3 = 2;
									}
									else {
										h += 3;
										if(h3 < 3)
											h3 = 3;
									}
								}
							//}
						}
					}
				}
			}
		}
		////
		aFace = etat.frontFace[1][2];
		bFace = etat.rightFace[1][0];
		if(aFace == etat.frontFace[1][1]) {
			if(bFace == etat.rightFace[1][1]) {
				h += 0;
			}
			else {
				if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
					h += 1;
					if(h3 < 1)
						h3 = 1;
				}
				else {
					h += 2;
					if(h3 < 2)
						h3 = 2;
				}
			}
		}
		else {
			if(aFace == etat.rightFace[1][1]) {
				if(bFace == etat.frontFace[1][1]) {
					h += 3;
					if(h3 < 3)
						h3 = 3;
				}
				else {
					if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
						h += 2;
						if(h3 < 2)
							h3 = 2;
					}
					else {
						h += 3;
						if(h3 < 3)
							h3 = 3;
					}
				}
			}
			else {
				if(aFace == etat.downFace[1][1]) {
					if(bFace == etat.rightFace[1][1]) {
						h += 1;
						if(h3 < 1)
							h3 = 1;
					}
					else {
						if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
							h += 2;
							if(h3 < 2)
								h3 = 2;
						}
						else {
							h += 3;
							if(h3 < 3)
								h3 = 3;
						}
					}
				}
				else {
					if(aFace == etat.upFace[1][1]) {
						if(bFace == etat.rightFace[1][1]) {
							h += 1;
							if(h3 < 1)
								h3 = 1;
						}
						else {
							if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								h += 3;
								if(h3 < 3)
									h3 = 3;
							}
						}
					}
					else {
						if(aFace == etat.backFace[1][1]) {
							if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								//if(etat.leftFace[0][1] == etat.frontFace[1][1] || etat.leftFace[0][1] == etat.backFace[1][1]) {
									h += 3;
									if(h3 < 3)
										h3 = 3;
								//}
							}
						}
						else {
							//if(etat.upFace[1][0] == etat.rightFace[1][1]) {
								if(bFace == etat.frontFace[1][1]) {
									h += 1;
									if(h3 < 1)
										h3 = 1;
								}
								else {
									if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
										h += 2;
										if(h3 < 2)
											h3 = 2;
									}
									else {
										h += 3;
										if(h3 < 3)
											h3 = 3;
									}
								}
							//}
						}
					}
				}
			}
		}
		
		aFace = etat.backFace[1][0];
		bFace = etat.rightFace[1][2];
		if(aFace == etat.backFace[1][1]) {
			if(bFace == etat.rightFace[1][1]) {
				h += 0;
			}
			else {
				if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
					h += 1;
					if(h3 < 1)
						h3 = 1;
				}
				else {
					h += 2;
					if(h3 < 2)
						h3 = 2;
				}
			}
		}
		else {
			if(aFace == etat.rightFace[1][1]) {
				if(bFace == etat.backFace[1][1]) {
					h += 3;
					if(h3 < 3)
						h3 = 3;
				}
				else {
					if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
						h += 2;
						if(h3 < 2)
							h3 = 2;
					}
					else {
						h += 3;
						if(h3 < 3)
							h3 = 3;
					}
				}
			}
			else {
				if(aFace == etat.upFace[1][1]) {
					if(bFace == etat.rightFace[1][1]) {
						h += 1;
						if(h3 < 1)
							h3 = 1;
					}
					else {
						if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
							h += 2;
							if(h3 < 2)
								h3 = 2;
						}
						else {
							h += 3;
							if(h3 < 3)
								h3 = 3;
						}
					}
				}
				else {
					if(aFace == etat.downFace[1][1]) {
						if(bFace == etat.rightFace[1][1]) {
							h += 1;
							if(h3 < 1)
								h3 = 1;
						}
						else {
							if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								h += 3;
								if(h3 < 3)
									h3 = 3;
							}
						}
					}
					else {
						if(aFace == etat.frontFace[1][1]) {
							if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								//if(etat.leftFace[0][1] == etat.frontFace[1][1] || etat.leftFace[0][1] == etat.backFace[1][1]) {
									h += 3;
									if(h3 < 3)
										h3 = 3;
								//}
							}
						}
						else {
							//if(etat.upFace[1][0] == etat.rightFace[1][1]) {
								if(bFace == etat.backFace[1][1]) {
									h += 1;
									if(h3 < 1)
										h3 = 1;
								}
								else {
									if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
										h += 2;
										if(h3 < 2)
											h3 = 2;
									}
									else {
										h += 3;
										if(h3 < 3)
											h3 = 3;
									}
								}
							//}
						}
					}
				}
			}
		}
		///////
		aFace = etat.frontFace[1][0];
		bFace = etat.leftFace[1][2];
		if(aFace == etat.frontFace[1][1]) {
			if(bFace == etat.leftFace[1][1]) {
				h += 0;
			}
			else {
				if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
					h += 1;
					if(h3 < 1)
						h3 = 1;
				}
				else {
					h += 2;
					if(h3 < 2)
						h3 = 2;
				}
			}
		}
		else {
			if(aFace == etat.leftFace[1][1]) {
				if(bFace == etat.frontFace[1][1]) {
					h += 3;
					if(h3 < 3)
						h3 = 3;
				}
				else {
					if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
						h += 2;
						if(h3 < 2)
							h3 = 2;
					}
					else {
						h += 3;
						if(h3 < 3)
							h3 = 3;
					}
				}
			}
			else {
				if(aFace == etat.upFace[1][1]) {
					if(bFace == etat.leftFace[1][1]) {
						h += 1;
						if(h3 < 1)
							h3 = 1;
					}
					else {
						if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
							h += 2;
							if(h3 < 2)
								h3 = 2;
						}
						else {
							h += 3;
							if(h3 < 3)
								h3 = 3;
						}
					}
				}
				else {
					if(aFace == etat.downFace[1][1]) {
						if(bFace == etat.leftFace[1][1]) {
							h += 1;
							if(h3 < 1)
								h3 = 1;
						}
						else {
							if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								h += 3;
								if(h3 < 3)
									h3 = 3;
							}
						}
					}
					else {
						if(aFace == etat.backFace[1][1]) {
							if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								//if(etat.leftFace[0][1] == etat.frontFace[1][1] || etat.leftFace[0][1] == etat.backFace[1][1]) {
									h += 3;
									if(h3 < 3)
										h3 = 3;
								//}
							}
						}
						else {
							//if(etat.upFace[1][0] == etat.rightFace[1][1]) {
								if(bFace == etat.frontFace[1][1]) {
									h += 1;
									if(h3 < 1)
										h3 = 1;
								}
								else {
									if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
										h += 2;
										if(h3 < 2)
											h3 = 2;
									}
									else {
										h += 3;
										if(h3 < 3)
											h3 = 3;
									}
								}
							//}
						}
					}
				}
			}
		}
		
		aFace = etat.backFace[1][2];
		bFace = etat.leftFace[1][0];
		if(aFace == etat.backFace[1][1]) {
			if(bFace == etat.leftFace[1][1]) {
				h += 0;
			}
			else {
				if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
					h += 1;
					if(h3 < 1)
						h3 = 1;
				}
				else {
					h += 2;
					if(h3 < 2)
						h3 = 2;
				}
			}
		}
		else {
			if(aFace == etat.leftFace[1][1]) {
				if(bFace == etat.backFace[1][1]) {
					h += 3;
					if(h3 < 3)
						h3 = 3;
				}
				else {
					if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
						h += 2;
						if(h3 < 2)
							h3 = 2;
					}
					else {
						h += 3;
						if(h3 < 3)
							h3 = 3;
					}
				}
			}
			else {
				if(aFace == etat.downFace[1][1]) {
					if(bFace == etat.leftFace[1][1]) {
						h += 1;
						if(h3 < 1)
							h3 = 1;
					}
					else {
						if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
							h += 2;
							if(h3 < 2)
								h3 = 2;
						}
						else {
							h += 3;
							if(h3 < 3)
								h3 = 3;
						}
					}
				}
				else {
					if(aFace == etat.upFace[1][1]) {
						if(bFace == etat.leftFace[1][1]) {
							h += 1;
							if(h3 < 1)
								h3 = 1;
						}
						else {
							if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								h += 3;
								if(h3 < 3)
									h3 = 3;
							}
						}
					}
					else {
						if(aFace == etat.frontFace[1][1]) {
							if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
								h += 2;
								if(h3 < 2)
									h3 = 2;
							}
							else {
								//if(etat.leftFace[0][1] == etat.frontFace[1][1] || etat.leftFace[0][1] == etat.backFace[1][1]) {
									h += 3;
									if(h3 < 3)
										h3 = 3;
								//}
							}
						}
						else {
							//if(etat.upFace[1][0] == etat.rightFace[1][1]) {
								if(bFace == etat.backFace[1][1]) {
									h += 1;
									if(h3 < 1)
										h3 = 1;
								}
								else {
									if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
										h += 2;
										if(h3 < 2)
											h3 = 2;
									}
									else {
										h += 3;
										if(h3 < 3)
											h3 = 3;
									}
								}
							//}
						}
					}
				}
			}
		}
		
		float h2 = 0;
		float h4 = 0;
		
		aFace = etat.upFace[2][0];
		bFace = etat.leftFace[0][2];
		char cFace = etat.frontFace[0][0];
		if(aFace == etat.upFace[1][1]) {
			if(bFace == etat.leftFace[1][1]) {
				//if(cFace == etat.frontFace[1][1]) {
					h2 += 0;
				//}
				//else {
					//cas impossible
				//}
			}else {
				if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
					h2 += 1;
					if(h4 < 1)
						h4 = 1;
				}
				else {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
			}
		}
		else {
			if(aFace == etat.frontFace[1][1]) {
				if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
				else {
					if(bFace == etat.leftFace[1][1]) {
						h2 += 1;
						if(h4 < 1)
							h4 = 1;
					}
					else {
						h2 += 3;
						if(h4 < 3)
							h4 = 3;
					}
				}
			}
			else {
				if(aFace == etat.leftFace[1][1]) {
					if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
						h2 += 2;
						if(h4 < 2)
							h4 = 2;
					}
					else {
						if(bFace == etat.downFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							h2 += 3;
							if(h4 < 3)
								h4 = 3;
						}
					}
				}
				else {
					if(aFace == etat.rightFace[1][1]) {
						if(bFace == etat.upFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							if(bFace == etat.downFace[1][1]) {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
							else {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
						}
					}
					else {
						if(aFace == etat.backFace[1][1]) {
							if(bFace == etat.leftFace[1][1]) {
								h2 += 1;
								if(h4 < 1)
									h4 = 1;
							}
							else {
								if(bFace == etat.rightFace[1][1]) {
									h2 += 3;
									if(h4 < 3)
										h4 = 3;
								}else {
									h2 += 2;
									if(h4 < 2)
										h4 = 2;
								}
							}
						}
						else {
							//if(aFace == etat.downFace[1][1])
							if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
							else {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
						}
					}
				}
			}
		}
		
		aFace = etat.upFace[2][2];
		bFace = etat.frontFace[0][2];
		cFace = etat.rightFace[0][0];
		if(aFace == etat.upFace[1][1]) {
			if(bFace == etat.frontFace[1][1]) {
				//if(cFace == etat.frontFace[1][1]) {
					h2 += 0;
				//}
				//else {
					//cas impossible
				//}
			}else {
				if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
					h2 += 1;
					if(h4 < 1)
						h4 = 1;
				}
				else {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
			}
		}
		else {
			if(aFace == etat.rightFace[1][1]) {
				if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
				else {
					if(bFace == etat.frontFace[1][1]) {
						h2 += 1;
						if(h4 < 1)
							h4 = 1;
					}
					else {
						h2 += 3;
						if(h4 < 3)
							h4 = 3;
					}
				}
			}
			else {
				if(aFace == etat.frontFace[1][1]) {
					if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
						h2 += 2;
						if(h4 < 2)
							h4 = 2;
					}
					else {
						if(bFace == etat.downFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							h2 += 3;
							if(h4 < 3)
								h4 = 3;
						}
					}
				}
				else {
					if(aFace == etat.backFace[1][1]) {
						if(bFace == etat.upFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							if(bFace == etat.downFace[1][1]) {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
							else {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
						}
					}
					else {
						if(aFace == etat.leftFace[1][1]) {
							if(bFace == etat.frontFace[1][1]) {
								h2 += 1;
								if(h4 < 1)
									h4 = 1;
							}
							else {
								if(bFace == etat.backFace[1][1]) {
									h2 += 3;
									if(h4 < 3)
										h4 = 3;
								}else {
									h2 += 2;
									if(h4 < 3)
										h4 = 3;
								}
							}
						}
						else {
							//if(aFace == etat.downFace[1][1])
							if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
							else {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
						}
					}
				}
			}
		}
		
		aFace = etat.upFace[0][2];
		bFace = etat.rightFace[0][2];
		cFace = etat.backFace[0][0];
		if(aFace == etat.upFace[1][1]) {
			if(bFace == etat.rightFace[1][1]) {
				//if(cFace == etat.frontFace[1][1]) {
					h2 += 0;
				//}
				//else {
					//cas impossible
				//}
			}else {
				if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
					h2 += 1;
					if(h4 < 1)
						h4 = 1;
				}
				else {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
			}
		}
		else {
			if(aFace == etat.backFace[1][1]) {
				if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
				else {
					if(bFace == etat.rightFace[1][1]) {
						h2 += 1;
						if(h4 < 1)
							h4 = 1;
					}
					else {
						h2 += 3;
						if(h4 < 3)
							h4 = 3;
					}
				}
			}
			else {
				if(aFace == etat.rightFace[1][1]) {
					if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
						h2 += 2;
						if(h4 < 2)
							h4 = 2;
					}
					else {
						if(bFace == etat.downFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							h2 += 3;
							if(h4 < 3)
								h4 = 3;
						}
					}
				}
				else {
					if(aFace == etat.leftFace[1][1]) {
						if(bFace == etat.upFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							if(bFace == etat.downFace[1][1]) {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
							else {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
						}
					}
					else {
						if(aFace == etat.frontFace[1][1]) {
							if(bFace == etat.rightFace[1][1]) {
								h2 += 1;
								if(h4 < 1)
									h4 = 1;
							}
							else {
								if(bFace == etat.leftFace[1][1]) {
									h2 += 3;
									if(h4 < 3)
										h4 = 3;
								}else {
									h2 += 2;
									if(h4 < 2)
										h4 = 2;
								}
							}
						}
						else {
							//if(aFace == etat.downFace[1][1])
							if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
							else {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
						}
					}
				}
			}
		}
		
		aFace = etat.upFace[0][0];
		bFace = etat.backFace[0][2];
		cFace = etat.leftFace[0][0];
		if(aFace == etat.upFace[1][1]) {
			if(bFace == etat.backFace[1][1]) {
				//if(cFace == etat.frontFace[1][1]) {
					h2 += 0;
				//}
				//else {
					//cas impossible
				//}
			}else {
				if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
					h2 += 1;
					if(h4 < 1)
						h4 = 1;
				}
				else {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
			}
		}
		else {
			if(aFace == etat.leftFace[1][1]) {
				if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
				else {
					if(bFace == etat.backFace[1][1]) {
						h2 += 1;
						if(h4 < 1)
							h4 = 1;
					}
					else {
						h2 += 3;
						if(h4 < 3)
							h4 = 3;
					}
				}
			}
			else {
				if(aFace == etat.backFace[1][1]) {
					if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
						h2 += 2;
						if(h4 < 2)
							h4 = 2;
					}
					else {
						if(bFace == etat.downFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							h2 += 3;
							if(h4 < 3)
								h4 = 3;
						}
					}
				}
				else {
					if(aFace == etat.frontFace[1][1]) {
						if(bFace == etat.upFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							if(bFace == etat.downFace[1][1]) {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
							else {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
						}
					}
					else {
						if(aFace == etat.rightFace[1][1]) {
							if(bFace == etat.backFace[1][1]) {
								h2 += 1;
								if(h4 < 1)
									h4 = 1;
							}
							else {
								if(bFace == etat.frontFace[1][1]) {
									h2 += 3;
									if(h4 < 3)
										h4 = 3;
								}else {
									h2 += 2;
									if(h4 < 2)
										h4 = 2;
								}
							}
						}
						else {
							//if(aFace == etat.downFace[1][1])
							if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
							else {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
						}
					}
				}
			}
		}
		
		aFace = etat.frontFace[2][0];
		bFace = etat.leftFace[2][2];
		cFace = etat.downFace[0][0];
		if(aFace == etat.frontFace[1][1]) {
			if(bFace == etat.leftFace[1][1]) {
				//if(cFace == etat.frontFace[1][1]) {
					h2 += 0;
				//}
				//else {
					//cas impossible
				//}
			}else {
				if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
					h2 += 1;
					if(h4 < 1)
						h4 = 1;
				}
				else {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
			}
		}
		else {
			if(aFace == etat.downFace[1][1]) {
				if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
				else {
					if(bFace == etat.leftFace[1][1]) {
						h2 += 1;
						if(h4 < 1)
							h4 = 1;
					}
					else {
						h2 += 3;
						if(h4 < 3)
							h4 = 3;
					}
				}
			}
			else {
				if(aFace == etat.leftFace[1][1]) {
					if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
						h2 += 2;
						if(h4 < 2)
							h4 = 2;
					}
					else {
						if(bFace == etat.backFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							h2 += 3;
							if(h4 < 3)
								h4 = 3;
						}
					}
				}
				else {
					if(aFace == etat.rightFace[1][1]) {
						if(bFace == etat.frontFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							if(bFace == etat.backFace[1][1]) {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
							else {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
						}
					}
					else {
						if(aFace == etat.upFace[1][1]) {
							if(bFace == etat.leftFace[1][1]) {
								h2 += 1;
								if(h4 < 1)
									h4 = 1;
							}
							else {
								if(bFace == etat.rightFace[1][1]) {
									h2 += 3;
									if(h4 < 3)
										h4 = 3;
								}else {
									h2 += 2;
									if(h4 < 2)
										h4 = 2;
								}
							}
						}
						else {
							//if(aFace == etat.downFace[1][1])
							if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
							else {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
						}
					}
				}
			}
		}
		
		aFace = etat.rightFace[2][0];
		bFace = etat.frontFace[2][2];
		cFace = etat.downFace[0][2];
		if(aFace == etat.rightFace[1][1]) {
			if(bFace == etat.frontFace[1][1]) {
				//if(cFace == etat.frontFace[1][1]) {
					h2 += 0;
				//}
				//else {
					//cas impossible
				//}
			}else {
				if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
					h2 += 1;
					if(h4 < 1)
						h4 = 1;
				}
				else {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
			}
		}
		else {
			if(aFace == etat.downFace[1][1]) {
				if(bFace == etat.rightFace[1][1] || bFace == etat.leftFace[1][1]) {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
				else {
					if(bFace == etat.frontFace[1][1]) {
						h2 += 1;
						if(h4 < 1)
							h4 = 1;
					}
					else {
						h2 += 3;
						if(h4 < 3)
							h4 = 3;
					}
				}
			}
			else {
				if(aFace == etat.frontFace[1][1]) {
					if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
						h2 += 2;
						if(h4 < 2)
							h4 = 2;
					}
					else {
						if(bFace == etat.leftFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							h2 += 3;
							if(h4 < 3)
								h4 = 3;
						}
					}
				}
				else {
					if(aFace == etat.backFace[1][1]) {
						if(bFace == etat.rightFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							if(bFace == etat.leftFace[1][1]) {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
							else {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
						}
					}
					else {
						if(aFace == etat.upFace[1][1]) {
							if(bFace == etat.frontFace[1][1]) {
								h2 += 1;
								if(h4 < 1)
									h4 = 1;
							}
							else {
								if(bFace == etat.backFace[1][1]) {
									h2 += 3;
									if(h4 < 3)
										h4 = 3;
								}else {
									h2 += 2;
									if(h4 < 2)
										h4 = 2;
								}
							}
						}
						else {
							//if(aFace == etat.downFace[1][1])
							if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
							else {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
						}
					}
				}
			}
		}
		
		aFace = etat.backFace[2][0];
		bFace = etat.rightFace[2][2];
		cFace = etat.downFace[2][2];
		if(aFace == etat.backFace[1][1]) {
			if(bFace == etat.rightFace[1][1]) {
				//if(cFace == etat.frontFace[1][1]) {
					h2 += 0;
				//}
				//else {
					//cas impossible
				//}
			}else {
				if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
					h2 += 1;
					if(h4 < 1)
						h4 = 1;
				}
				else {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
			}
		}
		else {
			if(aFace == etat.downFace[1][1]) {
				if(bFace == etat.backFace[1][1] || bFace == etat.frontFace[1][1]) {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
				else {
					if(bFace == etat.rightFace[1][1]) {
						h2 += 1;
						if(h4 < 1)
							h4 = 1;
					}
					else {
						h2 += 3;
						if(h4 < 3)
							h4 = 3;
					}
				}
			}
			else {
				if(aFace == etat.rightFace[1][1]) {
					if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
						h2 += 2;
						if(h4 < 2)
							h4 = 2;
					}
					else {
						if(bFace == etat.frontFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							h2 += 3;
							if(h4 < 3)
								h4 = 3;
						}
					}
				}
				else {
					if(aFace == etat.leftFace[1][1]) {
						if(bFace == etat.backFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							if(bFace == etat.frontFace[1][1]) {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
							else {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
						}
					}
					else {
						if(aFace == etat.upFace[1][1]) {
							if(bFace == etat.rightFace[1][1]) {
								h2 += 1;
								if(h4 < 1)
									h4 = 1;
							}
							else {
								if(bFace == etat.leftFace[1][1]) {
									h2 += 3;
									if(h4 < 3)
										h4 = 3;
								}else {
									h2 += 2;
									if(h4 < 2)
										h4 = 2;
								}
							}
						}
						else {
							//if(aFace == etat.downFace[1][1])
							if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
							else {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
						}
					}
				}
			}
		}
		
		aFace = etat.leftFace[2][0];
		bFace = etat.backFace[2][2];
		cFace = etat.downFace[2][0];
		if(aFace == etat.leftFace[1][1]) {
			if(bFace == etat.backFace[1][1]) {
				//if(cFace == etat.frontFace[1][1]) {
					h2 += 0;
				//}
				//else {
					//cas impossible
				//}
			}else {
				if(bFace == etat.upFace[1][1] || bFace == etat.downFace[1][1]) {
					h2 += 1;
					if(h4 < 1)
						h4 = 1;
				}
				else {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
			}
		}
		else {
			if(aFace == etat.downFace[1][1]) {
				if(bFace == etat.leftFace[1][1] || bFace == etat.rightFace[1][1]) {
					h2 += 2;
					if(h4 < 2)
						h4 = 2;
				}
				else {
					if(bFace == etat.backFace[1][1]) {
						h2 += 1;
						if(h4 < 1)
							h4 = 1;
					}
					else {
						h2 += 3;
						if(h4 < 3)
							h4 = 3;
					}
				}
			}
			else {
				if(aFace == etat.backFace[1][1]) {
					if(bFace == etat.downFace[1][1] || bFace == etat.upFace[1][1]) {
						h2 += 2;
						if(h4 < 2)
							h4 = 2;
					}
					else {
						if(bFace == etat.rightFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							h2 += 3;
							if(h4 < 3)
								h4 = 3;
						}
					}
				}
				else {
					if(aFace == etat.frontFace[1][1]) {
						if(bFace == etat.leftFace[1][1]) {
							h2 += 1;
							if(h4 < 1)
								h4 = 1;
						}
						else {
							if(bFace == etat.rightFace[1][1]) {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
							else {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
						}
					}
					else {
						if(aFace == etat.upFace[1][1]) {
							if(bFace == etat.backFace[1][1]) {
								h2 += 1;
								if(h4 < 1)
									h4 = 1;
							}
							else {
								if(bFace == etat.frontFace[1][1]) {
									h2 += 3;
									if(h4 < 3)
										h4 = 3;
								}else {
									h2 += 2;
									if(h4 < 2)
										h4 = 2;
								}
							}
						}
						else {
							//if(aFace == etat.downFace[1][1])
							if(bFace == etat.frontFace[1][1] || bFace == etat.backFace[1][1]) {
								h2 += 2;
								if(h4 < 2)
									h4 = 2;
							}
							else {
								h2 += 3;
								if(h4 < 3)
									h4 = 3;
							}
						}
					}
				}
			}
		}
		
		float maxh = (h>h2?h/4:h2/4), maxhprim = (h3>h4?h3:h4);
		return (maxh>maxhprim?maxh:maxhprim);
	}
}
